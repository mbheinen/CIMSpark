package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Models Market clearing results.
 *
 * Indicates market horizon, interval based. Used by a market quality system for billing and settlement purposes
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AllocationResultValues [[ch.ninecode.model.AllocationResultValues AllocationResultValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class AllocationResult
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String,
    AllocationResultValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AllocationResult] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AllocationResult.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AllocationResult.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AllocationResult.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AllocationResultValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationResult rdf:ID=\"%s\">\n%s\t</cim:AllocationResult>".format (id, export_fields)
    }
}

object AllocationResult
extends
    Parseable[AllocationResult]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AllocationResultValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AllocationResultValues", "AllocationResultValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AllocationResultValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): AllocationResult =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AllocationResult (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AllocationResultValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models Market clearing results in terms of price and MW values
 *
 * @param sup Reference to the superclass object.
 * @param aggregateType "1" --  "Detail",
 *        "2" --  "Aggregate by Market service type", in which case, the "AllocationEnergyType" field will not be filled;
 *        "3" --  "Aggregate by "AllocationEnergyType", in which case "MarketServiceType" will not be filled.
 * @param allocationMwHour <em>undocumented</em>
 * @param allocationPrice <em>undocumented</em>
 * @param energyTypeCode <em>undocumented</em>
 * @param marketServiceType Choices are:
 *        ME - Market Energy Capacity;
 *        SR - Spinning Reserve Capacity;
 *        NR - Non-Spinning Reserve Capacity;
 *        DAC - Day Ahead Capacity;
 *        DEC - Derate Capacity
 * @param AllocationResult [[ch.ninecode.model.AllocationResult AllocationResult]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class AllocationResultValues
(
    override val sup: BasicElement,
    aggregateType: String,
    allocationMwHour: Double,
    allocationPrice: Double,
    energyTypeCode: String,
    marketServiceType: String,
    AllocationResult: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AllocationResultValues] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AllocationResultValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AllocationResultValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AllocationResultValues.fields (position), value)
        emitelem (0, aggregateType)
        emitelem (1, allocationMwHour)
        emitelem (2, allocationPrice)
        emitelem (3, energyTypeCode)
        emitelem (4, marketServiceType)
        emitattr (5, AllocationResult)
        emitattr (6, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationResultValues rdf:ID=\"%s\">\n%s\t</cim:AllocationResultValues>".format (id, export_fields)
    }
}

object AllocationResultValues
extends
    Parseable[AllocationResultValues]
{
    override val fields: Array[String] = Array[String] (
        "aggregateType",
        "allocationMwHour",
        "allocationPrice",
        "energyTypeCode",
        "marketServiceType",
        "AllocationResult",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AllocationResult", "AllocationResult", "1", "1..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val aggregateType: Fielder = parse_element (element (cls, fields(0)))
    val allocationMwHour: Fielder = parse_element (element (cls, fields(1)))
    val allocationPrice: Fielder = parse_element (element (cls, fields(2)))
    val energyTypeCode: Fielder = parse_element (element (cls, fields(3)))
    val marketServiceType: Fielder = parse_element (element (cls, fields(4)))
    val AllocationResult: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): AllocationResultValues =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AllocationResultValues (
            BasicElement.parse (context),
            mask (aggregateType (), 0),
            toDouble (mask (allocationMwHour (), 1)),
            toDouble (mask (allocationPrice (), 2)),
            mask (energyTypeCode (), 3),
            mask (marketServiceType (), 4),
            mask (AllocationResult (), 5),
            mask (RegisteredResource (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models Market clearing results for Auxillary costs
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryValues [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class AuxiliaryCost
(
    override val sup: BasicElement,
    intervalStartTime: String,
    marketType: String,
    updateTimeStamp: String,
    updateUser: String,
    AuxillaryValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryCost] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryCost.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryCost.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryCost.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AuxiliaryCost.fields (position), x))
        emitelem (0, intervalStartTime)
        emitattr (1, marketType)
        emitelem (2, updateTimeStamp)
        emitelem (3, updateUser)
        emitattrs (4, AuxillaryValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryCost rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryCost>".format (id, export_fields)
    }
}

object AuxiliaryCost
extends
    Parseable[AuxiliaryCost]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "marketType",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryValues", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val AuxillaryValues: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): AuxiliaryCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryCost (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (marketType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateUser (), 3),
            masks (AuxillaryValues (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models Auxillary Values
 *
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class AuxiliaryObject
(
    override val sup: BasicElement,
    RegisteredGenerator: String,
    RegisteredLoad: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryObject] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryObject.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryObject.fields (position), value)
        emitattr (0, RegisteredGenerator)
        emitattr (1, RegisteredLoad)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryObject rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryObject>".format (id, export_fields)
    }
}

object AuxiliaryObject
extends
    Parseable[AuxiliaryObject]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator",
        "RegisteredLoad"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..*"),
        Relationship ("RegisteredLoad", "RegisteredLoad", "0..1", "0..*")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredLoad: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AuxiliaryObject =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryObject (
            BasicElement.parse (context),
            mask (RegisteredGenerator (), 0),
            mask (RegisteredLoad (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models Auxillary Values
 *
 * @param sup [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] Reference to the superclass object.
 * @param availUndispatchedQ <em>undocumented</em>
 * @param incrementalORAvail <em>undocumented</em>
 * @param maxExpostCapacity <em>undocumented</em>
 * @param minExpostCapacity <em>undocumented</em>
 * @param noLoadCost <em>undocumented</em>
 * @param noLoadCostEligibilityFlag <em>undocumented</em>
 * @param startUpCost <em>undocumented</em>
 * @param startUpCostEligibilityFlag <em>undocumented</em>
 * @param AuxillaryCost [[ch.ninecode.model.AuxiliaryCost AuxiliaryCost]] <em>undocumented</em>
 * @param FiveMinAuxillaryData [[ch.ninecode.model.FiveMinAuxiliaryData FiveMinAuxiliaryData]] <em>undocumented</em>
 * @param TenMinAuxillaryData [[ch.ninecode.model.TenMinAuxiliaryData TenMinAuxiliaryData]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class AuxiliaryValues
(
    override val sup: AuxiliaryObject,
    availUndispatchedQ: Double,
    incrementalORAvail: Double,
    maxExpostCapacity: Double,
    minExpostCapacity: Double,
    noLoadCost: Double,
    noLoadCostEligibilityFlag: String,
    startUpCost: Double,
    startUpCostEligibilityFlag: String,
    AuxillaryCost: String,
    FiveMinAuxillaryData: String,
    TenMinAuxillaryData: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AuxiliaryObject: AuxiliaryObject = sup.asInstanceOf[AuxiliaryObject]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryValues] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryValues.fields (position), value)
        emitelem (0, availUndispatchedQ)
        emitelem (1, incrementalORAvail)
        emitelem (2, maxExpostCapacity)
        emitelem (3, minExpostCapacity)
        emitelem (4, noLoadCost)
        emitattr (5, noLoadCostEligibilityFlag)
        emitelem (6, startUpCost)
        emitattr (7, startUpCostEligibilityFlag)
        emitattr (8, AuxillaryCost)
        emitattr (9, FiveMinAuxillaryData)
        emitattr (10, TenMinAuxillaryData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryValues rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryValues>".format (id, export_fields)
    }
}

object AuxiliaryValues
extends
    Parseable[AuxiliaryValues]
{
    override val fields: Array[String] = Array[String] (
        "availUndispatchedQ",
        "incrementalORAvail",
        "maxExpostCapacity",
        "minExpostCapacity",
        "noLoadCost",
        "noLoadCostEligibilityFlag",
        "startUpCost",
        "startUpCostEligibilityFlag",
        "AuxillaryCost",
        "FiveMinAuxillaryData",
        "TenMinAuxillaryData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryCost", "AuxiliaryCost", "1", "1..*"),
        Relationship ("FiveMinAuxillaryData", "FiveMinAuxiliaryData", "1", "1..*"),
        Relationship ("TenMinAuxillaryData", "TenMinAuxiliaryData", "1", "1..*")
    )
    val availUndispatchedQ: Fielder = parse_element (element (cls, fields(0)))
    val incrementalORAvail: Fielder = parse_element (element (cls, fields(1)))
    val maxExpostCapacity: Fielder = parse_element (element (cls, fields(2)))
    val minExpostCapacity: Fielder = parse_element (element (cls, fields(3)))
    val noLoadCost: Fielder = parse_element (element (cls, fields(4)))
    val noLoadCostEligibilityFlag: Fielder = parse_attribute (attribute (cls, fields(5)))
    val startUpCost: Fielder = parse_element (element (cls, fields(6)))
    val startUpCostEligibilityFlag: Fielder = parse_attribute (attribute (cls, fields(7)))
    val AuxillaryCost: Fielder = parse_attribute (attribute (cls, fields(8)))
    val FiveMinAuxillaryData: Fielder = parse_attribute (attribute (cls, fields(9)))
    val TenMinAuxillaryData: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): AuxiliaryValues =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryValues (
            AuxiliaryObject.parse (context),
            toDouble (mask (availUndispatchedQ (), 0)),
            toDouble (mask (incrementalORAvail (), 1)),
            toDouble (mask (maxExpostCapacity (), 2)),
            toDouble (mask (minExpostCapacity (), 3)),
            toDouble (mask (noLoadCost (), 4)),
            mask (noLoadCostEligibilityFlag (), 5),
            toDouble (mask (startUpCost (), 6)),
            mask (startUpCostEligibilityFlag (), 7),
            mask (AuxillaryCost (), 8),
            mask (FiveMinAuxillaryData (), 9),
            mask (TenMinAuxillaryData (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model Expected Energy  from Market Clearing, interval based
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param ExpectedEnergyValues [[ch.ninecode.model.ExpectedEnergyValues ExpectedEnergyValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class ExpectedEnergy
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String,
    ExpectedEnergyValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExpectedEnergy] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExpectedEnergy.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExpectedEnergy.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ExpectedEnergy.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, ExpectedEnergyValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergy rdf:ID=\"%s\">\n%s\t</cim:ExpectedEnergy>".format (id, export_fields)
    }
}

object ExpectedEnergy
extends
    Parseable[ExpectedEnergy]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "ExpectedEnergyValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExpectedEnergyValues", "ExpectedEnergyValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val ExpectedEnergyValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ExpectedEnergy =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExpectedEnergy (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (ExpectedEnergyValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model Expected Energy  from Market Clearing
 *
 * @param sup Reference to the superclass object.
 * @param energyTypeCode <em>undocumented</em>
 * @param expectedMwh <em>undocumented</em>
 * @param ExpectedEnergy [[ch.ninecode.model.ExpectedEnergy ExpectedEnergy]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class ExpectedEnergyValues
(
    override val sup: BasicElement,
    energyTypeCode: String,
    expectedMwh: Double,
    ExpectedEnergy: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExpectedEnergyValues] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExpectedEnergyValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExpectedEnergyValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExpectedEnergyValues.fields (position), value)
        emitelem (0, energyTypeCode)
        emitelem (1, expectedMwh)
        emitattr (2, ExpectedEnergy)
        emitattr (3, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergyValues rdf:ID=\"%s\">\n%s\t</cim:ExpectedEnergyValues>".format (id, export_fields)
    }
}

object ExpectedEnergyValues
extends
    Parseable[ExpectedEnergyValues]
{
    override val fields: Array[String] = Array[String] (
        "energyTypeCode",
        "expectedMwh",
        "ExpectedEnergy",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExpectedEnergy", "ExpectedEnergy", "1", "1..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val energyTypeCode: Fielder = parse_element (element (cls, fields(0)))
    val expectedMwh: Fielder = parse_element (element (cls, fields(1)))
    val ExpectedEnergy: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ExpectedEnergyValues =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExpectedEnergyValues (
            BasicElement.parse (context),
            mask (energyTypeCode (), 0),
            toDouble (mask (expectedMwh (), 1)),
            mask (ExpectedEnergy (), 2),
            mask (RegisteredResource (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models 5-Minutes Auxillary Data
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryValues [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class FiveMinAuxiliaryData
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String,
    AuxillaryValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FiveMinAuxiliaryData] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FiveMinAuxiliaryData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FiveMinAuxiliaryData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (FiveMinAuxiliaryData.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AuxillaryValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FiveMinAuxiliaryData rdf:ID=\"%s\">\n%s\t</cim:FiveMinAuxiliaryData>".format (id, export_fields)
    }
}

object FiveMinAuxiliaryData
extends
    Parseable[FiveMinAuxiliaryData]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryValues", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): FiveMinAuxiliaryData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FiveMinAuxiliaryData (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AuxillaryValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models 10-Minutes Auxillary Data
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryData [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class TenMinAuxiliaryData
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String,
    AuxillaryData: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TenMinAuxiliaryData] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TenMinAuxiliaryData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TenMinAuxiliaryData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TenMinAuxiliaryData.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AuxillaryData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TenMinAuxiliaryData rdf:ID=\"%s\">\n%s\t</cim:TenMinAuxiliaryData>".format (id, export_fields)
    }
}

object TenMinAuxiliaryData
extends
    Parseable[TenMinAuxiliaryData]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryData", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryData: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): TenMinAuxiliaryData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TenMinAuxiliaryData (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AuxillaryData (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models prices at Trading Hubs, interval based
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param TradingHubValues [[ch.ninecode.model.TradingHubValues TradingHubValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class TradingHubPrice
(
    override val sup: BasicElement,
    intervalStartTime: String,
    marketType: String,
    updateTimeStamp: String,
    updateUser: String,
    TradingHubValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradingHubPrice] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TradingHubPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradingHubPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradingHubPrice.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TradingHubPrice.fields (position), x))
        emitelem (0, intervalStartTime)
        emitattr (1, marketType)
        emitelem (2, updateTimeStamp)
        emitelem (3, updateUser)
        emitattrs (4, TradingHubValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradingHubPrice rdf:ID=\"%s\">\n%s\t</cim:TradingHubPrice>".format (id, export_fields)
    }
}

object TradingHubPrice
extends
    Parseable[TradingHubPrice]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "marketType",
        "updateTimeStamp",
        "updateUser",
        "TradingHubValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TradingHubValues", "TradingHubValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val TradingHubValues: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): TradingHubPrice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TradingHubPrice (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (marketType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateUser (), 3),
            masks (TradingHubValues (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models prices at Trading Hubs
 *
 * @param sup Reference to the superclass object.
 * @param price Utilizes the Market type.
 *        For DA, the price is hourly. For RTM the price is a 5 minute price.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param TradingHubPrice [[ch.ninecode.model.TradingHubPrice TradingHubPrice]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
case class TradingHubValues
(
    override val sup: BasicElement,
    price: Double,
    AggregatedPnode: String,
    TradingHubPrice: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradingHubValues] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TradingHubValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradingHubValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradingHubValues.fields (position), value)
        emitelem (0, price)
        emitattr (1, AggregatedPnode)
        emitattr (2, TradingHubPrice)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradingHubValues rdf:ID=\"%s\">\n%s\t</cim:TradingHubValues>".format (id, export_fields)
    }
}

object TradingHubValues
extends
    Parseable[TradingHubValues]
{
    override val fields: Array[String] = Array[String] (
        "price",
        "AggregatedPnode",
        "TradingHubPrice"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "1", "0..*"),
        Relationship ("TradingHubPrice", "TradingHubPrice", "1", "1..*")
    )
    val price: Fielder = parse_element (element (cls, fields(0)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TradingHubPrice: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TradingHubValues =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TradingHubValues (
            BasicElement.parse (context),
            toDouble (mask (price (), 0)),
            mask (AggregatedPnode (), 1),
            mask (TradingHubPrice (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _MarketQualitySystem
{
    def register: List[ClassInfo] =
    {
        List (
            AllocationResult.register,
            AllocationResultValues.register,
            AuxiliaryCost.register,
            AuxiliaryObject.register,
            AuxiliaryValues.register,
            ExpectedEnergy.register,
            ExpectedEnergyValues.register,
            FiveMinAuxiliaryData.register,
            TenMinAuxiliaryData.register,
            TradingHubPrice.register,
            TradingHubValues.register
        )
    }
}