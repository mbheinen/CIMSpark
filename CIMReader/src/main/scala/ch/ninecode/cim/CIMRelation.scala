package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.FileIndex
import org.apache.spark.sql.execution.datasources.FileFormat
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.sources.TableScan
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.ElementRegistration
import org.apache.spark.storage.StorageLevel
import org.slf4j.{Logger, LoggerFactory}

import ch.ninecode.model.Element

class CIMRelation (
    location: FileIndex,
    partitionSchema: StructType,
    dataSchema: StructType,
    fileFormat: FileFormat,
    parameters: Map[String, String]) (spark: SparkSession) extends BaseRelation with TableScan
{

    // We use BaseRelation because if it inherits from HadoopFSRelation,
    // DataSource uses the CIMFileFormat which doesn't allow subsetting, etc. :
    //extends
    //    HadoopFsRelation (
    //        location,
    //        partitionSchema,
    //        dataSchema,
    //        None, // org.apache.spark.sql.execution.datasources.BucketSpec is private
    //        fileFormat,
    //        parameters) (spark)

    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    def parseState (text: String): State =
        text match
        {
            case "ForceTrue" ⇒ ForceTrue
            case "ForceFalse" ⇒ ForceFalse
            case _ ⇒ Unforced
        }

    val paths: Array[String] = location.inputFiles

    // check for a storage level option
    implicit val _StorageLevel: StorageLevel = StorageLevel.fromString (parameters.getOrElse ("StorageLevel", "MEMORY_AND_DISK_SER"))
    // check for rdf:about option
    val _About: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_about", "false").toBoolean
    // check for normalization option
    val _Normalize: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_normalize", "false").toBoolean
    // check for deduplication option
    val _DeDup: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_deduplication", "false").toBoolean
    // check for edge creation option
    val _Edges: Boolean = parameters.getOrElse ("ch.ninecode.cim.make_edges", "false").toBoolean
    // check for ISU join option
    val _Join: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_join", "false").toBoolean
    // check for NTP island option
    val _Islands: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_topo_islands", "false").toBoolean
    // check for NTP option, islands requires topological nodes
    val _Topo: Boolean = if (_Islands) true else parameters.getOrElse ("ch.ninecode.cim.do_topo", "false").toBoolean
    // check for NTP force switches option
    val _Force_Retain_Switches: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_retain_switches", "Unforced"))
    // check for NTP force fuses option
    val _Force_Retain_Fuses: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_retain_fuses", "Unforced"))
    // check for NTP force switches to separate islands option
    val _Force_Switch_Separate_Islands: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_switch_separate_islands", "Unforced"))
    // check for NTP force fuses to separate islands option
    val _Force_Fuse_Separate_Islands: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_fuse_separate_islands", "Unforced"))
    // check for NTP default switch state option
    val _Default_Switch_Open_State: Boolean = parameters.getOrElse ("ch.ninecode.cim.default_switch_open_state", "false").toBoolean
    // check for NTP debug option
    val _Debug: Boolean = parameters.getOrElse ("ch.ninecode.cim.debug", "false").toBoolean
    // check for split size option, default is 64MB
    val _SplitSize: Long = parameters.getOrElse ("ch.ninecode.cim.split_maxsize", "67108864").toLong
    // check for cache option
    val _Cache: String = parameters.getOrElse ("ch.ninecode.cim.cache", "")

    val _TopologyOptions = CIMTopologyOptions (
        identify_islands = _Islands,
        force_retain_switches = _Force_Retain_Switches,
        force_retain_fuses = _Force_Retain_Fuses,
        force_switch_separate_islands = _Force_Switch_Separate_Islands,
        force_fuse_separate_islands = _Force_Fuse_Separate_Islands,
        default_switch_open_state = _Default_Switch_Open_State,
        debug = _Debug,
        storage = _StorageLevel
    )

    log.info ("parameters: " + parameters.toString)
    log.info ("storage: " + _StorageLevel.description)

    def sqlContext: SQLContext = spark.sqlContext

    // just to get a schema
    case class dummy
    (
        override val sup: Element = null
    )
    extends
        Element

    /**
     * Specifies schema of actual data files.  For partitioned relations, if one or more partitioned
     * columns are contained in the data files, they should also appear in `dataSchema`.
     *
     * @since 1.4.0
     */
    override def schema: StructType =
    {
        // we cheat here: the elements in the elements rdd are full Scala hierarchical objects,
        // but we say here they only have one field of type Element because for some that is all they have
        // (lowest common denominator)
        Encoders.product[dummy].schema
    }

    def make_tables (rdd: RDD[Element]): Unit =
    {
        val names = rdd.flatMap (
            (x: Element) => // hierarchy: List[String]
            {
                var ret = List[String]()
                var clz = x

                while (null != clz)
                {
                    ret = ret :+ clz.getClass.getName
                    clz = clz.sup
                }

                ret.map (x => x.substring (x.lastIndexOf (".") + 1))
            }
        ).map (s ⇒ (s, s)).reduceByKey ((x, _) => x).map (_._1).collect
        CHIM.apply_to_all_classes (
            (subsetter: CIMSubsetter[_]) =>
            {
                // in earlier Scala versions this loop doesn't work well
                // the symptoms are:
                //     scala.reflect.runtime.ReflectError: value ch is not a package
                // or
                //     java.lang.RuntimeException: error reading Scala signature of ch.ninecode.model.BusBarSectionInfo: value model is not a package
                // due to https://issues.apache.org/jira/browse/SPARK-2178
                // which is due to https://issues.scala-lang.org/browse/SI-6240
                // and described in http://docs.scala-lang.org/overviews/reflection/thread-safety.html
                // p.s. Scala's type system is a shit show of kludgy code
                if (names.contains (subsetter.cls))
                {
                    log.debug ("building " + subsetter.cls)
                    subsetter.make (spark.sqlContext, rdd, _StorageLevel)
                }
            }
        )
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (): RDD[Row] =
    {
        log.info ("buildScan")

        // register the ElementUDT
        ElementRegistration.register ()

        var ret: RDD[Row] = null

        if (_Cache != "")
        {
            val path = new Path (_Cache)
            val configuration = new Configuration (spark.sparkContext.hadoopConfiguration)
            val fs = path.getFileSystem (configuration)
            if (fs.exists (path))
            {
                val rdd: RDD[Element] = spark.sparkContext.objectFile (_Cache)
                ret = rdd.asInstanceOf[RDD[Row]]
                ret.setName ("Elements")
                ret.persist (_StorageLevel)
                if (spark.sparkContext.getCheckpointDir.isDefined) ret.checkpoint ()
                make_tables (rdd)
            }
        }

        if (null == ret)
        {
            val path = if (parameters.contains ("path"))
                parameters("path")
            else
                paths.mkString (",")

            // make a config
            val configuration = new Configuration (spark.sparkContext.hadoopConfiguration)
            configuration.set (FileInputFormat.INPUT_DIR, path)
            configuration.setLong (FileInputFormat.SPLIT_MAXSIZE, _SplitSize)

            var rdd = spark.sparkContext.newAPIHadoopRDD (
                configuration,
                classOf[CIMInputFormat],
                classOf[String],
                classOf[Element]).values

            ret = rdd.asInstanceOf[RDD[Row]]
            ret.setName ("Elements")
            ret.persist (_StorageLevel)
            if (spark.sparkContext.getCheckpointDir.isDefined) ret.checkpoint ()

            // about processing if requested
            if (_About)
            {
                val about = new CIMAbout (spark, _StorageLevel)
                rdd = about.do_about ()
                ret = rdd.asInstanceOf[RDD[Row]]
            }

            // normalize if requested
            if (_Normalize)
            {
                val normalize = new CIMNormalize (spark, _StorageLevel)
                rdd = normalize.do_normalization ()
                ret = rdd.asInstanceOf[RDD[Row]]
            }

            // dedup if requested
            if (_DeDup)
            {
                val dedup = new CIMDeDup (spark, _StorageLevel)
                rdd = dedup.do_deduplicate ()
                ret = rdd.asInstanceOf[RDD[Row]]
            }

            // as a side effect, define all the other temporary tables
            log.info ("creating temporary tables")
            make_tables (rdd)

            // merge ISU and NIS ServiceLocations if requested
            if (_Join)
            {
                val join = new CIMJoin (spark, _StorageLevel)
                ret = join.do_join ().asInstanceOf[RDD[Row]]
            }

            // perform topological processing if requested
            if (_Topo)
            {
                val ntp = new CIMNetworkTopologyProcessor (spark, _StorageLevel)
                ret = ntp.process (_TopologyOptions).asInstanceOf[RDD[Row]]
            }

            // set up edge graph if requested
            if (_Edges)
            {
                val cimedges = new CIMEdges (spark, _StorageLevel)
                ret = cimedges.make_edges (_Topo).asInstanceOf[RDD[Row]]
            }

            // cache elements if requested
            if (_Cache != "")
                ret.saveAsObjectFile (_Cache)
        }

        ret
    }
}