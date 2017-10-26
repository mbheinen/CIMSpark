package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Requirements for minimum amount of reserve and/or regulation to be supplied by a set of qualified resources.
 *
 * @param sup [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] Reference to the superclass object.
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] Market product associated with reserve requirement must be a reserve or regulation product.
 * @param ReserveReqCurve [[ch.ninecode.model.ReserveReqCurve ReserveReqCurve]] <em>undocumented</em>
 * @param SensitivityPriceCurve [[ch.ninecode.model.SensitivityPriceCurve SensitivityPriceCurve]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ReserveReq
(
    override val sup: ResourceGroupReq,
    MarketProduct: String,
    ReserveReqCurve: String,
    SensitivityPriceCurve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ResourceGroupReq: ResourceGroupReq = sup.asInstanceOf[ResourceGroupReq]
    override def copy (): Row = { clone ().asInstanceOf[ReserveReq] }
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
        implicit val clz: String = ReserveReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReserveReq.fields (position), value)
        emitattr (0, MarketProduct)
        emitattr (1, ReserveReqCurve)
        emitattr (2, SensitivityPriceCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReserveReq rdf:ID=\"%s\">\n%s\t</cim:ReserveReq>".format (id, export_fields)
    }
}

object ReserveReq
extends
    Parseable[ReserveReq]
{
    val fields: Array[String] = Array[String] (
        "MarketProduct",
        "ReserveReqCurve",
        "SensitivityPriceCurve"
    )
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ReserveReqCurve: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SensitivityPriceCurve: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ReserveReq =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReserveReq (
            ResourceGroupReq.parse (context),
            mask (MarketProduct (), 0),
            mask (ReserveReqCurve (), 1),
            mask (SensitivityPriceCurve (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketProduct", "MarketProduct", false),
        Relationship ("ReserveReqCurve", "ReserveReqCurve", false),
        Relationship ("SensitivityPriceCurve", "SensitivityPriceCurve", false)
    )
}

/**
 * A curve relating  reserve requirement versus time, showing the values of a specific reserve requirement for each unit of the period covered.
 *
 * The  curve can be based on "absolute" time or on "normalized' time.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ReserveReqCurve
(
    override val sup: Curve,
    ReserveReq: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReserveReqCurve] }
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
        implicit val clz: String = ReserveReqCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReserveReqCurve.fields (position), value)
        emitattr (0, ReserveReq)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReserveReqCurve rdf:ID=\"%s\">\n%s\t</cim:ReserveReqCurve>".format (id, export_fields)
    }
}

object ReserveReqCurve
extends
    Parseable[ReserveReqCurve]
{
    val fields: Array[String] = Array[String] (
        "ReserveReq"
    )
    val ReserveReq: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ReserveReqCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReserveReqCurve (
            Curve.parse (context),
            mask (ReserveReq (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ReserveReq", "ReserveReq", false)
    )
}

/**
 * A logical grouping of resources that are used to model location of types of requirements for ancillary services such as spinning reserve zones, regulation zones, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status Status of this group.
 * @param typ Type of this group.
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ResourceGroup
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ResourceGroup] }
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
        implicit val clz: String = ResourceGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceGroup.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceGroup.fields (position), value)
        emitattr (0, status)
        emitelem (1, typ)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceGroup rdf:ID=\"%s\">\n%s\t</cim:ResourceGroup>".format (id, export_fields)
    }
}

object ResourceGroup
extends
    Parseable[ResourceGroup]
{
    val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): ResourceGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceGroup (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (typ (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Ancillary service requirements for a market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTOs [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param ResourceGroup [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class ResourceGroupReq
(
    override val sup: IdentifiedObject,
    RTOs: List[String],
    ResourceGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ResourceGroupReq] }
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
        implicit val clz: String = ResourceGroupReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceGroupReq.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ResourceGroupReq.fields (position), x))
        emitattrs (0, RTOs)
        emitattr (1, ResourceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceGroupReq rdf:ID=\"%s\">\n%s\t</cim:ResourceGroupReq>".format (id, export_fields)
    }
}

object ResourceGroupReq
extends
    Parseable[ResourceGroupReq]
{
    val fields: Array[String] = Array[String] (
        "RTOs",
        "ResourceGroup"
    )
    val RTOs: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ResourceGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ResourceGroupReq =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceGroupReq (
            IdentifiedObject.parse (context),
            masks (RTOs (), 0),
            mask (ResourceGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RTOs", "RTO", true),
        Relationship ("ResourceGroup", "ResourceGroup", false)
    )
}

/**
 * Optionally, this curve expresses elasticity of the associated requirement.
 *
 * For example, used to reduce requirements when clearing price exceeds reasonable values when the supply quantity becomes scarce. For example, a single point value of \$1000/MW for a spinning reserve will cause a reduction in the required spinning reserve.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
case class SensitivityPriceCurve
(
    override val sup: Curve,
    ReserveReq: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[SensitivityPriceCurve] }
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
        implicit val clz: String = SensitivityPriceCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SensitivityPriceCurve.fields (position), value)
        emitattr (0, ReserveReq)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SensitivityPriceCurve rdf:ID=\"%s\">\n%s\t</cim:SensitivityPriceCurve>".format (id, export_fields)
    }
}

object SensitivityPriceCurve
extends
    Parseable[SensitivityPriceCurve]
{
    val fields: Array[String] = Array[String] (
        "ReserveReq"
    )
    val ReserveReq: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SensitivityPriceCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SensitivityPriceCurve (
            Curve.parse (context),
            mask (ReserveReq (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ReserveReq", "ReserveReq", false)
    )
}

private[ninecode] object _InfExternalInputs
{
    def register: List[ClassInfo] =
    {
        List (
            ReserveReq.register,
            ReserveReqCurve.register,
            ResourceGroup.register,
            ResourceGroupReq.register,
            SensitivityPriceCurve.register
        )
    }
}