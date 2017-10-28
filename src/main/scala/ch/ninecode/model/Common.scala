package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Records activity for an entity at a point in time; activity may be for an event that has already occurred or for a planned activity.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param createdDateTime Date and time this activity record has been created (different from the 'status.dateTime', which is the time of a status change of the associated object, if applicable).
 * @param reason Reason for event resulting in this activity record, typically supplied when user initiated.
 * @param severity Severity level of event resulting in this activity record.
 * @param status [[ch.ninecode.model.Status Status]] Information on consequence of event resulting in this activity record.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets for which this activity record has been created.
 * @param Organisations [[ch.ninecode.model.Organisation Organisation]] <em>undocumented</em>
 * @param `type` Type of event resulting in this activity record.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class ActivityRecord
(
    override val sup: IdentifiedObject,
    createdDateTime: String,
    reason: String,
    severity: String,
    status: String,
    Assets: List[String],
    Organisations: List[String],
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ActivityRecord] }
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
        implicit val clz: String = ActivityRecord.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ActivityRecord.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ActivityRecord.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ActivityRecord.fields (position), x))
        emitelem (0, createdDateTime)
        emitelem (1, reason)
        emitelem (2, severity)
        emitattr (3, status)
        emitattrs (4, Assets)
        emitattrs (5, Organisations)
        emitelem (6, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ActivityRecord rdf:ID=\"%s\">\n%s\t</cim:ActivityRecord>".format (id, export_fields)
    }
}

object ActivityRecord
extends
    Parseable[ActivityRecord]
{
    val fields: Array[String] = Array[String] (
        "createdDateTime",
        "reason",
        "severity",
        "status",
        "Assets",
        "Organisations",
        "type"
    )
    val createdDateTime: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_element (element (cls, fields(1)))
    val severity: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Organisations: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val `type`: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): ActivityRecord =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ActivityRecord (
            IdentifiedObject.parse (context),
            mask (createdDateTime (), 0),
            mask (reason (), 1),
            mask (severity (), 2),
            mask (status (), 3),
            masks (Assets (), 4),
            masks (Organisations (), 5),
            mask (`type` (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("Assets", "Asset", true),
        Relationship ("Organisations", "Organisation", true)
    )
}

/**
 * Formal agreement between two parties defining the terms and conditions for a set of services.
 *
 * The specifics of the services are, in turn, defined via one or more service agreements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param signDate Date this agreement was consummated among associated persons and/or organisations.
 * @param validityInterval Date and time interval this agreement is valid (from going into effect to termination).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Agreement
(
    override val sup: Document,
    signDate: String,
    validityInterval: String
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Agreement] }
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
        implicit val clz: String = Agreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Agreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Agreement.fields (position), value)
        emitelem (0, signDate)
        emitattr (1, validityInterval)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Agreement rdf:ID=\"%s\">\n%s\t</cim:Agreement>".format (id, export_fields)
    }
}

object Agreement
extends
    Parseable[Agreement]
{
    val fields: Array[String] = Array[String] (
        "signDate",
        "validityInterval"
    )
    val signDate: Fielder = parse_element (element (cls, fields(0)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Agreement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Agreement (
            Document.parse (context),
            mask (signDate (), 0),
            mask (validityInterval (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Meeting time and location.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param callAhead True if requested to call customer when someone is about to arrive at their premises.
 * @param meetingInterval Date and time reserved for appointment.
 * @param Persons [[ch.ninecode.model.PersonRole PersonRole]] All persons for this appointment.
 * @param Works [[ch.ninecode.model.Work Work]] All works for this appointment.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Appointment
(
    override val sup: IdentifiedObject,
    callAhead: Boolean,
    meetingInterval: String,
    Persons: List[String],
    Works: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Appointment] }
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
        implicit val clz: String = Appointment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Appointment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Appointment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Appointment.fields (position), x))
        emitelem (0, callAhead)
        emitattr (1, meetingInterval)
        emitattrs (2, Persons)
        emitattrs (3, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Appointment rdf:ID=\"%s\">\n%s\t</cim:Appointment>".format (id, export_fields)
    }
}

object Appointment
extends
    Parseable[Appointment]
{
    val fields: Array[String] = Array[String] (
        "callAhead",
        "meetingInterval",
        "Persons",
        "Works"
    )
    val callAhead: Fielder = parse_element (element (cls, fields(0)))
    val meetingInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Persons: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Appointment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Appointment (
            IdentifiedObject.parse (context),
            toBoolean (mask (callAhead (), 0)),
            mask (meetingInterval (), 1),
            masks (Persons (), 2),
            masks (Works (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Persons", "PersonRole", true),
        Relationship ("Works", "Work", true)
    )
}

/**
 * Used to report details on creation, change or deletion of an entity or its configuration.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param effectiveDateTime Date and time this event has or will become effective.
 * @param modifiedBy Source/initiator of modification.
 * @param remark Free text remarks.
 * @param ChangedAsset [[ch.ninecode.model.Asset Asset]] Asset whose change resulted in this configuration event.
 * @param ChangedDocument [[ch.ninecode.model.Document Document]] Document whose change resulted in this configuration event.
 * @param ChangedLocation [[ch.ninecode.model.Location Location]] Location whose change resulted in this configuration event.
 * @param ChangedOrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Organisation role whose change resulted in this configuration event.
 * @param ChangedPersonRole [[ch.ninecode.model.PersonRole PersonRole]] Person role whose change resulted in this configuration event.
 * @param ChangedServiceCategory [[ch.ninecode.model.ServiceCategory ServiceCategory]] Service category whose change resulted in this configuration event.
 * @param ChangedUsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point whose change resulted in this configuration event.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class ConfigurationEvent
(
    override val sup: ActivityRecord,
    effectiveDateTime: String,
    modifiedBy: String,
    remark: String,
    ChangedAsset: String,
    ChangedDocument: String,
    ChangedLocation: String,
    ChangedOrganisationRole: String,
    ChangedPersonRole: String,
    ChangedServiceCategory: String,
    ChangedUsagePoint: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[ConfigurationEvent] }
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
        implicit val clz: String = ConfigurationEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConfigurationEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConfigurationEvent.fields (position), value)
        emitelem (0, effectiveDateTime)
        emitelem (1, modifiedBy)
        emitelem (2, remark)
        emitattr (3, ChangedAsset)
        emitattr (4, ChangedDocument)
        emitattr (5, ChangedLocation)
        emitattr (6, ChangedOrganisationRole)
        emitattr (7, ChangedPersonRole)
        emitattr (8, ChangedServiceCategory)
        emitattr (9, ChangedUsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConfigurationEvent rdf:ID=\"%s\">\n%s\t</cim:ConfigurationEvent>".format (id, export_fields)
    }
}

object ConfigurationEvent
extends
    Parseable[ConfigurationEvent]
{
    val fields: Array[String] = Array[String] (
        "effectiveDateTime",
        "modifiedBy",
        "remark",
        "ChangedAsset",
        "ChangedDocument",
        "ChangedLocation",
        "ChangedOrganisationRole",
        "ChangedPersonRole",
        "ChangedServiceCategory",
        "ChangedUsagePoint"
    )
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(0)))
    val modifiedBy: Fielder = parse_element (element (cls, fields(1)))
    val remark: Fielder = parse_element (element (cls, fields(2)))
    val ChangedAsset: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ChangedDocument: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ChangedLocation: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ChangedOrganisationRole: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ChangedPersonRole: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ChangedServiceCategory: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ChangedUsagePoint: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): ConfigurationEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConfigurationEvent (
            ActivityRecord.parse (context),
            mask (effectiveDateTime (), 0),
            mask (modifiedBy (), 1),
            mask (remark (), 2),
            mask (ChangedAsset (), 3),
            mask (ChangedDocument (), 4),
            mask (ChangedLocation (), 5),
            mask (ChangedOrganisationRole (), 6),
            mask (ChangedPersonRole (), 7),
            mask (ChangedServiceCategory (), 8),
            mask (ChangedUsagePoint (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChangedAsset", "Asset", false),
        Relationship ("ChangedDocument", "Document", false),
        Relationship ("ChangedLocation", "Location", false),
        Relationship ("ChangedOrganisationRole", "OrganisationRole", false),
        Relationship ("ChangedPersonRole", "PersonRole", false),
        Relationship ("ChangedServiceCategory", "ServiceCategory", false),
        Relationship ("ChangedUsagePoint", "UsagePoint", false)
    )
}

/**
 * Coordinate reference system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param crsUrn A Uniform Resource Name (URN) for the coordinate reference system (crs) used to define 'Location.
 *        PositionPoints'.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class CoordinateSystem
(
    override val sup: IdentifiedObject,
    crsUrn: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CoordinateSystem] }
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
        implicit val clz: String = CoordinateSystem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CoordinateSystem.fields (position), value)
        emitelem (0, crsUrn)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CoordinateSystem rdf:ID=\"%s\">\n%s\t</cim:CoordinateSystem>".format (id, export_fields)
    }
}

object CoordinateSystem
extends
    Parseable[CoordinateSystem]
{
    val fields: Array[String] = Array[String] (
        "crsUrn"
    )
    val crsUrn: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): CoordinateSystem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CoordinateSystem (
            IdentifiedObject.parse (context),
            mask (crsUrn (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Group of people with specific skills, tools, and vehicles.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this crew.
 * @param CrewType [[ch.ninecode.model.CrewType CrewType]] Type of this crew.
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All work tasks this crew participates in.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Crew
(
    override val sup: IdentifiedObject,
    status: String,
    CrewType: String,
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Crew] }
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
        implicit val clz: String = Crew.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Crew.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Crew.fields (position), x))
        emitattr (0, status)
        emitattr (1, CrewType)
        emitattrs (2, WorkTasks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Crew rdf:ID=\"%s\">\n%s\t</cim:Crew>".format (id, export_fields)
    }
}

object Crew
extends
    Parseable[Crew]
{
    val fields: Array[String] = Array[String] (
        "status",
        "CrewType",
        "WorkTasks"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CrewType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Crew =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Crew (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (CrewType (), 1),
            masks (WorkTasks (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("CrewType", "CrewType", false),
        Relationship ("WorkTasks", "WorkTask", true)
    )
}

/**
 * Member of a crew.
 *
 * @param sup [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew to which this crew member belongs.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class CrewMember
(
    override val sup: OperationPersonRole,
    Crew: String
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
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[CrewMember] }
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
        implicit val clz: String = CrewMember.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CrewMember.fields (position), value)
        emitattr (0, Crew)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CrewMember rdf:ID=\"%s\">\n%s\t</cim:CrewMember>".format (id, export_fields)
    }
}

object CrewMember
extends
    Parseable[CrewMember]
{
    val fields: Array[String] = Array[String] (
        "Crew"
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CrewMember =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CrewMember (
            OperationPersonRole.parse (context),
            mask (Crew (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Crew", "Crew", false)
    )
}

/**
 * Custom description of the type of crew.
 *
 * This may be used to determine the type of work the crew can be assigned to. Examples include repair, tree trimming, switching, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class CrewType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CrewType] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CrewType rdf:ID=\"%s\">\n%s\t</cim:CrewType>".format (id, export_fields)
    }
}

object CrewType
extends
    Parseable[CrewType]
{

    def parse (context: Context): CrewType =
    {
        implicit val ctx: Context = context
        val ret = CrewType (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Parent class for different groupings of information collected and managed as a part of a business process.
 *
 * It will frequently contain references to other objects, such as assets, people and power system resources.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param authorName Name of the author of this document.
 * @param comment Free text comment.
 * @param createdDateTime Date and time that this document was created.
 * @param docStatus [[ch.ninecode.model.Status Status]] Status of this document.
 *        For status of subject matter this document represents (e.g., Agreement, Work), use 'status' attribute.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param lastModifiedDateTime Date and time this document was last modified.
 *        Documents may potentially be modified many times during their lifetime.
 * @param revisionNumber Revision number for this document.
 * @param status [[ch.ninecode.model.Status Status]] Status of subject matter (e.g., Agreement, Work) this document represents.
 *        For status of the document itself, use 'docStatus' attribute.
 * @param subject Document subject.
 * @param title Document title.
 * @param `type` Utility-specific classification of this document, according to its corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Document
(
    override val sup: IdentifiedObject,
    authorName: String,
    comment: String,
    createdDateTime: String,
    docStatus: String,
    electronicAddress: String,
    lastModifiedDateTime: String,
    revisionNumber: String,
    status: String,
    subject: String,
    title: String,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Document] }
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
        implicit val clz: String = Document.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Document.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Document.fields (position), value)
        emitelem (0, authorName)
        emitelem (1, comment)
        emitelem (2, createdDateTime)
        emitattr (3, docStatus)
        emitattr (4, electronicAddress)
        emitelem (5, lastModifiedDateTime)
        emitelem (6, revisionNumber)
        emitattr (7, status)
        emitelem (8, subject)
        emitelem (9, title)
        emitelem (10, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Document rdf:ID=\"%s\">\n%s\t</cim:Document>".format (id, export_fields)
    }
}

object Document
extends
    Parseable[Document]
{
    val fields: Array[String] = Array[String] (
        "authorName",
        "comment",
        "createdDateTime",
        "docStatus",
        "electronicAddress",
        "lastModifiedDateTime",
        "revisionNumber",
        "status",
        "subject",
        "title",
        "type"
    )
    val authorName: Fielder = parse_element (element (cls, fields(0)))
    val comment: Fielder = parse_element (element (cls, fields(1)))
    val createdDateTime: Fielder = parse_element (element (cls, fields(2)))
    val docStatus: Fielder = parse_attribute (attribute (cls, fields(3)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val lastModifiedDateTime: Fielder = parse_element (element (cls, fields(5)))
    val revisionNumber: Fielder = parse_element (element (cls, fields(6)))
    val status: Fielder = parse_attribute (attribute (cls, fields(7)))
    val subject: Fielder = parse_element (element (cls, fields(8)))
    val title: Fielder = parse_element (element (cls, fields(9)))
    val `type`: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): Document =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Document (
            IdentifiedObject.parse (context),
            mask (authorName (), 0),
            mask (comment (), 1),
            mask (createdDateTime (), 2),
            mask (docStatus (), 3),
            mask (electronicAddress (), 4),
            mask (lastModifiedDateTime (), 5),
            mask (revisionNumber (), 6),
            mask (status (), 7),
            mask (subject (), 8),
            mask (title (), 9),
            mask (`type` (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("docStatus", "Status", false),
        Relationship ("electronicAddress", "ElectronicAddress", false),
        Relationship ("status", "Status", false)
    )
}

/**
 * Electronic address information.
 *
 * @param sup Reference to the superclass object.
 * @param email1 Primary email address.
 * @param email2 Alternate email address.
 * @param lan Address on local area network.
 * @param mac MAC (Media Access Control) address.
 * @param password Password needed to log in.
 * @param radio Radio address.
 * @param userID User ID needed to log in, which can be for an individual person, an organisation, a location, etc.
 * @param web World wide web address.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class ElectronicAddress
(
    override val sup: BasicElement,
    email1: String,
    email2: String,
    lan: String,
    mac: String,
    password: String,
    radio: String,
    userID: String,
    web: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ElectronicAddress] }
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
        implicit val clz: String = ElectronicAddress.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ElectronicAddress.fields (position), value)
        emitelem (0, email1)
        emitelem (1, email2)
        emitelem (2, lan)
        emitelem (3, mac)
        emitelem (4, password)
        emitelem (5, radio)
        emitelem (6, userID)
        emitelem (7, web)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ElectronicAddress rdf:ID=\"%s\">\n%s\t</cim:ElectronicAddress>".format (id, export_fields)
    }
}

object ElectronicAddress
extends
    Parseable[ElectronicAddress]
{
    val fields: Array[String] = Array[String] (
        "email1",
        "email2",
        "lan",
        "mac",
        "password",
        "radio",
        "userID",
        "web"
    )
    val email1: Fielder = parse_element (element (cls, fields(0)))
    val email2: Fielder = parse_element (element (cls, fields(1)))
    val lan: Fielder = parse_element (element (cls, fields(2)))
    val mac: Fielder = parse_element (element (cls, fields(3)))
    val password: Fielder = parse_element (element (cls, fields(4)))
    val radio: Fielder = parse_element (element (cls, fields(5)))
    val userID: Fielder = parse_element (element (cls, fields(6)))
    val web: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): ElectronicAddress =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ElectronicAddress (
            BasicElement.parse (context),
            mask (email1 (), 0),
            mask (email2 (), 1),
            mask (lan (), 2),
            mask (mac (), 3),
            mask (password (), 4),
            mask (radio (), 5),
            mask (userID (), 6),
            mask (web (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An object or a condition that is a danger for causing loss or perils to an asset and/or people.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this hazard.
 * @param `type` Type of this hazard.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Hazard
(
    override val sup: IdentifiedObject,
    status: String,
    `type`: String
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
    override def copy (): Row = { clone ().asInstanceOf[Hazard] }
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
        implicit val clz: String = Hazard.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Hazard.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Hazard.fields (position), value)
        emitattr (0, status)
        emitelem (1, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Hazard rdf:ID=\"%s\">\n%s\t</cim:Hazard>".format (id, export_fields)
    }
}

object Hazard
extends
    Parseable[Hazard]
{
    val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Hazard =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Hazard (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false)
    )
}

/**
 * The place, scene, or point of something where someone or something has been, is, and/or will be at a given moment in time.
 *
 * It can be defined with one or more postition points (coordinates) in a given coordinate system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param direction (if applicable) Direction that allows field crews to quickly find a given asset.
 *        For a given location, such as a street address, this is the relative direction in which to find the asset. For example, a streetlight may be located at the 'NW' (northwest) corner of the customer's site, or a usage point may be located on the second floor of an apartment building.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param geoInfoReference (if applicable) Reference to geographical information source, often external to the utility.
 * @param mainAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Main address of the location.
 * @param phone1 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Phone number.
 * @param phone2 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Additional phone number.
 * @param secondaryAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Secondary address of the location.
 *        For example, PO Box address may have different ZIP code than that in the 'mainAddress'.
 * @param status [[ch.ninecode.model.Status Status]] Status of this location.
 * @param CoordinateSystem [[ch.ninecode.model.CoordinateSystem CoordinateSystem]] Coordinate system used to describe position points of this location.
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param Hazards [[ch.ninecode.model.AssetLocationHazard AssetLocationHazard]] All asset hazards at this location.
 * @param LandProperties [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @param Routes [[ch.ninecode.model.Route Route]] <em>undocumented</em>
 * @param `type` Classification by utility's corporate standards and practices, relative to the location itself (e.g., geographical, functional accounting, etc., not a given property that happens to exist at that location).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Location
(
    override val sup: IdentifiedObject,
    direction: String,
    electronicAddress: String,
    geoInfoReference: String,
    mainAddress: String,
    phone1: String,
    phone2: String,
    secondaryAddress: String,
    status: String,
    CoordinateSystem: String,
    Crews: List[String],
    Hazards: List[String],
    LandProperties: List[String],
    Measurements: List[String],
    Routes: List[String],
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, List(), List(), List(), List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Location] }
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
        implicit val clz: String = Location.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Location.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Location.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Location.fields (position), x))
        emitelem (0, direction)
        emitattr (1, electronicAddress)
        emitelem (2, geoInfoReference)
        emitattr (3, mainAddress)
        emitattr (4, phone1)
        emitattr (5, phone2)
        emitattr (6, secondaryAddress)
        emitattr (7, status)
        emitattr (8, CoordinateSystem)
        emitattrs (9, Crews)
        emitattrs (10, Hazards)
        emitattrs (11, LandProperties)
        emitattrs (12, Measurements)
        emitattrs (13, Routes)
        emitelem (14, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Location rdf:ID=\"%s\">\n%s\t</cim:Location>".format (id, export_fields)
    }
}

object Location
extends
    Parseable[Location]
{
    val fields: Array[String] = Array[String] (
        "direction",
        "electronicAddress",
        "geoInfoReference",
        "mainAddress",
        "phone1",
        "phone2",
        "secondaryAddress",
        "status",
        "CoordinateSystem",
        "Crews",
        "Hazards",
        "LandProperties",
        "Measurements",
        "Routes",
        "type"
    )
    val direction: Fielder = parse_element (element (cls, fields(0)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(1)))
    val geoInfoReference: Fielder = parse_element (element (cls, fields(2)))
    val mainAddress: Fielder = parse_attribute (attribute (cls, fields(3)))
    val phone1: Fielder = parse_attribute (attribute (cls, fields(4)))
    val phone2: Fielder = parse_attribute (attribute (cls, fields(5)))
    val secondaryAddress: Fielder = parse_attribute (attribute (cls, fields(6)))
    val status: Fielder = parse_attribute (attribute (cls, fields(7)))
    val CoordinateSystem: Fielder = parse_attribute (attribute (cls, fields(8)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Hazards: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Routes: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val `type`: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): Location =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Location (
            IdentifiedObject.parse (context),
            mask (direction (), 0),
            mask (electronicAddress (), 1),
            mask (geoInfoReference (), 2),
            mask (mainAddress (), 3),
            mask (phone1 (), 4),
            mask (phone2 (), 5),
            mask (secondaryAddress (), 6),
            mask (status (), 7),
            mask (CoordinateSystem (), 8),
            masks (Crews (), 9),
            masks (Hazards (), 10),
            masks (LandProperties (), 11),
            masks (Measurements (), 12),
            masks (Routes (), 13),
            mask (`type` (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", false),
        Relationship ("mainAddress", "StreetAddress", false),
        Relationship ("phone1", "TelephoneNumber", false),
        Relationship ("phone2", "TelephoneNumber", false),
        Relationship ("secondaryAddress", "StreetAddress", false),
        Relationship ("status", "Status", false),
        Relationship ("CoordinateSystem", "CoordinateSystem", false),
        Relationship ("Crews", "OldCrew", true),
        Relationship ("Hazards", "AssetLocationHazard", true),
        Relationship ("LandProperties", "LandProperty", true),
        Relationship ("Measurements", "Measurement", true),
        Relationship ("Routes", "Route", true)
    )
}

/**
 * Person role in the context of utility operations.
 *
 * @param sup [[ch.ninecode.model.PersonRole PersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class OperationPersonRole
(
    override val sup: PersonRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { clone ().asInstanceOf[OperationPersonRole] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:OperationPersonRole rdf:ID=\"%s\">\n%s\t</cim:OperationPersonRole>".format (id, export_fields)
    }
}

object OperationPersonRole
extends
    Parseable[OperationPersonRole]
{

    def parse (context: Context): OperationPersonRole =
    {
        implicit val ctx: Context = context
        val ret = OperationPersonRole (
            PersonRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Control room operator.
 *
 * @param sup [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Operator
(
    override val sup: OperationPersonRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Operator] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Operator rdf:ID=\"%s\">\n%s\t</cim:Operator>".format (id, export_fields)
    }
}

object Operator
extends
    Parseable[Operator]
{

    def parse (context: Context): Operator =
    {
        implicit val ctx: Context = context
        val ret = Operator (
            OperationPersonRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Organisation that might have roles as utility, contractor, supplier, manufacturer, customer, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param phone1 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Phone number.
 * @param phone2 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Additional phone number.
 * @param postalAddress [[ch.ninecode.model.PostalAddress PostalAddress]] Postal address, potentially different than 'streetAddress' (e.g., another city).
 * @param streetAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Street address.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] <em>undocumented</em>
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Organisation
(
    override val sup: IdentifiedObject,
    electronicAddress: String,
    phone1: String,
    phone2: String,
    postalAddress: String,
    streetAddress: String,
    ActivityRecords: List[String],
    Crews: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Organisation] }
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
        implicit val clz: String = Organisation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Organisation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Organisation.fields (position), x))
        emitattr (0, electronicAddress)
        emitattr (1, phone1)
        emitattr (2, phone2)
        emitattr (3, postalAddress)
        emitattr (4, streetAddress)
        emitattrs (5, ActivityRecords)
        emitattrs (6, Crews)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Organisation rdf:ID=\"%s\">\n%s\t</cim:Organisation>".format (id, export_fields)
    }
}

object Organisation
extends
    Parseable[Organisation]
{
    val fields: Array[String] = Array[String] (
        "electronicAddress",
        "phone1",
        "phone2",
        "postalAddress",
        "streetAddress",
        "ActivityRecords",
        "Crews"
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val phone1: Fielder = parse_attribute (attribute (cls, fields(1)))
    val phone2: Fielder = parse_attribute (attribute (cls, fields(2)))
    val postalAddress: Fielder = parse_attribute (attribute (cls, fields(3)))
    val streetAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Organisation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Organisation (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            mask (phone1 (), 1),
            mask (phone2 (), 2),
            mask (postalAddress (), 3),
            mask (streetAddress (), 4),
            masks (ActivityRecords (), 5),
            masks (Crews (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", false),
        Relationship ("phone1", "TelephoneNumber", false),
        Relationship ("phone2", "TelephoneNumber", false),
        Relationship ("postalAddress", "PostalAddress", false),
        Relationship ("streetAddress", "StreetAddress", false),
        Relationship ("ActivityRecords", "ActivityRecord", true),
        Relationship ("Crews", "OldCrew", true)
    )
}

/**
 * Identifies a way in which an organisation may participate in the utility enterprise (e.g., customer, manufacturer, etc).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Organisation having this role.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class OrganisationRole
(
    override val sup: IdentifiedObject,
    Organisation: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationRole] }
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
        implicit val clz: String = OrganisationRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationRole.fields (position), value)
        emitattr (0, Organisation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationRole rdf:ID=\"%s\">\n%s\t</cim:OrganisationRole>".format (id, export_fields)
    }
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
{
    val fields: Array[String] = Array[String] (
        "Organisation"
    )
    val Organisation: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): OrganisationRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OrganisationRole (
            IdentifiedObject.parse (context),
            mask (Organisation (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Organisation", "Organisation", false)
    )
}

/**
 * Ownership of e.g. asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param share Share of this ownership.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset that is object of this ownership.
 * @param AssetOwner [[ch.ninecode.model.AssetOwner AssetOwner]] Asset owner that is subject in this ownership.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Ownership
(
    override val sup: IdentifiedObject,
    share: Double,
    Asset: String,
    AssetOwner: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Ownership] }
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
        implicit val clz: String = Ownership.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Ownership.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Ownership.fields (position), value)
        emitelem (0, share)
        emitattr (1, Asset)
        emitattr (2, AssetOwner)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Ownership rdf:ID=\"%s\">\n%s\t</cim:Ownership>".format (id, export_fields)
    }
}

object Ownership
extends
    Parseable[Ownership]
{
    val fields: Array[String] = Array[String] (
        "share",
        "Asset",
        "AssetOwner"
    )
    val share: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AssetOwner: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Ownership =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Ownership (
            IdentifiedObject.parse (context),
            toDouble (mask (share (), 0)),
            mask (Asset (), 1),
            mask (AssetOwner (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false),
        Relationship ("AssetOwner", "AssetOwner", false)
    )
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param firstName Person's first name.
 * @param landlinePhone [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Landline phone number.
 * @param lastName Person's last (family, sir) name.
 * @param mName Middle name(s) or initial(s).
 * @param mobilePhone [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Mobile phone number.
 * @param prefix A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
 * @param specialNeed Special service needs for the person (contact) are described; examples include life support, etc.
 * @param suffix A suffix for the person's name, such as II, III, etc.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Person
(
    override val sup: IdentifiedObject,
    electronicAddress: String,
    firstName: String,
    landlinePhone: String,
    lastName: String,
    mName: String,
    mobilePhone: String,
    prefix: String,
    specialNeed: String,
    suffix: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Person] }
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
        implicit val clz: String = Person.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Person.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Person.fields (position), value)
        emitattr (0, electronicAddress)
        emitelem (1, firstName)
        emitattr (2, landlinePhone)
        emitelem (3, lastName)
        emitelem (4, mName)
        emitattr (5, mobilePhone)
        emitelem (6, prefix)
        emitelem (7, specialNeed)
        emitelem (8, suffix)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Person rdf:ID=\"%s\">\n%s\t</cim:Person>".format (id, export_fields)
    }
}

object Person
extends
    Parseable[Person]
{
    val fields: Array[String] = Array[String] (
        "electronicAddress",
        "firstName",
        "landlinePhone",
        "lastName",
        "mName",
        "mobilePhone",
        "prefix",
        "specialNeed",
        "suffix"
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val firstName: Fielder = parse_element (element (cls, fields(1)))
    val landlinePhone: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastName: Fielder = parse_element (element (cls, fields(3)))
    val mName: Fielder = parse_element (element (cls, fields(4)))
    val mobilePhone: Fielder = parse_attribute (attribute (cls, fields(5)))
    val prefix: Fielder = parse_element (element (cls, fields(6)))
    val specialNeed: Fielder = parse_element (element (cls, fields(7)))
    val suffix: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): Person =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Person (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            mask (firstName (), 1),
            mask (landlinePhone (), 2),
            mask (lastName (), 3),
            mask (mName (), 4),
            mask (mobilePhone (), 5),
            mask (prefix (), 6),
            mask (specialNeed (), 7),
            mask (suffix (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", false),
        Relationship ("landlinePhone", "TelephoneNumber", false),
        Relationship ("mobilePhone", "TelephoneNumber", false)
    )
}

/**

 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class PersonRole
(
    override val sup: IdentifiedObject,
    Appointments: List[String],
    Person: String
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
    override def copy (): Row = { clone ().asInstanceOf[PersonRole] }
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
        implicit val clz: String = PersonRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PersonRole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PersonRole.fields (position), x))
        emitattrs (0, Appointments)
        emitattr (1, Person)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PersonRole rdf:ID=\"%s\">\n%s\t</cim:PersonRole>".format (id, export_fields)
    }
}

object PersonRole
extends
    Parseable[PersonRole]
{
    val fields: Array[String] = Array[String] (
        "Appointments",
        "Person"
    )
    val Appointments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Person: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PersonRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PersonRole (
            IdentifiedObject.parse (context),
            masks (Appointments (), 0),
            mask (Person (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Appointments", "Appointment", true),
        Relationship ("Person", "Person", false)
    )
}

/**
 * Set of spatial coordinates that determine a point, defined in the coordinate system specified in 'Location.
 *
 * CoordinateSystem'. Use a single position point instance to desribe a point-oriented location. Use a sequence of position points to describe a line-oriented object (physical location of non-point oriented objects like cables or lines), or area of an object (like a substation or a geographical zone - in this case, have first and last position point with the same values).
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber Zero-relative sequence number of this point within a series of points.
 * @param xPosition X axis position.
 * @param yPosition Y axis position.
 * @param zPosition (if applicable) Z axis position.
 * @param Location [[ch.ninecode.model.Location Location]] Location described by this position point.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class PositionPoint
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    xPosition: String,
    yPosition: String,
    zPosition: String,
    Location: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PositionPoint] }
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
        implicit val clz: String = PositionPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PositionPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PositionPoint.fields (position), value)
        emitelem (0, sequenceNumber)
        emitelem (1, xPosition)
        emitelem (2, yPosition)
        emitelem (3, zPosition)
        emitattr (4, Location)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PositionPoint rdf:ID=\"%s\">\n%s\t</cim:PositionPoint>".format (id, export_fields)
    }
}

object PositionPoint
extends
    Parseable[PositionPoint]
{
    val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "Location"
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val xPosition: Fielder = parse_element (element (cls, fields(1)))
    val yPosition: Fielder = parse_element (element (cls, fields(2)))
    val zPosition: Fielder = parse_element (element (cls, fields(3)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): PositionPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PositionPoint (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (xPosition (), 1),
            mask (yPosition (), 2),
            mask (zPosition (), 3),
            mask (Location (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Location", "Location", false)
    )
}

/**
 * General purpose postal address information.
 *
 * @param sup Reference to the superclass object.
 * @param poBox Post office box.
 * @param postalCode Postal code for the address.
 * @param streetDetail [[ch.ninecode.model.StreetDetail StreetDetail]] Street detail.
 * @param townDetail [[ch.ninecode.model.TownDetail TownDetail]] Town detail.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class PostalAddress
(
    override val sup: BasicElement,
    poBox: String,
    postalCode: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PostalAddress] }
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
        implicit val clz: String = PostalAddress.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PostalAddress.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PostalAddress.fields (position), value)
        emitelem (0, poBox)
        emitelem (1, postalCode)
        emitattr (2, streetDetail)
        emitattr (3, townDetail)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PostalAddress rdf:ID=\"%s\">\n%s\t</cim:PostalAddress>".format (id, export_fields)
    }
}

object PostalAddress
extends
    Parseable[PostalAddress]
{
    val fields: Array[String] = Array[String] (
        "poBox",
        "postalCode",
        "streetDetail",
        "townDetail"
    )
    val poBox: Fielder = parse_element (element (cls, fields(0)))
    val postalCode: Fielder = parse_element (element (cls, fields(1)))
    val streetDetail: Fielder = parse_attribute (attribute (cls, fields(2)))
    val townDetail: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): PostalAddress =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PostalAddress (
            BasicElement.parse (context),
            mask (poBox (), 0),
            mask (postalCode (), 1),
            mask (streetDetail (), 2),
            mask (townDetail (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("streetDetail", "StreetDetail", false),
        Relationship ("townDetail", "TownDetail", false)
    )
}

/**
 * Priority definition.
 *
 * @param sup Reference to the superclass object.
 * @param justification Justification for 'rank'.
 * @param rank Priority level; usually, lower number means high priority, but the details are provided in 'type'.
 * @param `type` Type describing 'rank'; e.g., high, emergency, etc.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Priority
(
    override val sup: BasicElement,
    justification: String,
    rank: Int,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Priority] }
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
        implicit val clz: String = Priority.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Priority.fields (position), value)
        emitelem (0, justification)
        emitelem (1, rank)
        emitelem (2, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Priority rdf:ID=\"%s\">\n%s\t</cim:Priority>".format (id, export_fields)
    }
}

object Priority
extends
    Parseable[Priority]
{
    val fields: Array[String] = Array[String] (
        "justification",
        "rank",
        "type"
    )
    val justification: Fielder = parse_element (element (cls, fields(0)))
    val rank: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): Priority =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Priority (
            BasicElement.parse (context),
            mask (justification (), 0),
            toInteger (mask (rank (), 1)),
            mask (`type` (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An event to trigger one or more activities, such as reading a meter, recalculating a bill, requesting work, when generating units must be scheduled for maintenance, when a transformer is scheduled to be refurbished, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param duration Duration of the scheduled event, for example, the time to ramp between values.
 * @param status [[ch.ninecode.model.Status Status]] <em>undocumented</em>
 * @param Assets [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param ScheduledEventData [[ch.ninecode.model.ScheduledEventData ScheduledEventData]] Specification for this scheduled event.
 * @param `type` Type of scheduled event.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class ScheduledEvent
(
    override val sup: IdentifiedObject,
    duration: Double,
    status: String,
    Assets: List[String],
    ScheduledEventData: String,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEvent] }
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
        implicit val clz: String = ScheduledEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ScheduledEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ScheduledEvent.fields (position), x))
        emitelem (0, duration)
        emitattr (1, status)
        emitattrs (2, Assets)
        emitattr (3, ScheduledEventData)
        emitelem (4, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledEvent rdf:ID=\"%s\">\n%s\t</cim:ScheduledEvent>".format (id, export_fields)
    }
}

object ScheduledEvent
extends
    Parseable[ScheduledEvent]
{
    val fields: Array[String] = Array[String] (
        "duration",
        "status",
        "Assets",
        "ScheduledEventData",
        "type"
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ScheduledEventData: Fielder = parse_attribute (attribute (cls, fields(3)))
    val `type`: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): ScheduledEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ScheduledEvent (
            IdentifiedObject.parse (context),
            toDouble (mask (duration (), 0)),
            mask (status (), 1),
            masks (Assets (), 2),
            mask (ScheduledEventData (), 3),
            mask (`type` (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("Assets", "Asset", true),
        Relationship ("ScheduledEventData", "ScheduledEventData", false)
    )
}

/**
 * Schedule parameters for an activity that is to occur, is occurring, or has completed.
 *
 * @param sup Reference to the superclass object.
 * @param estimatedWindow Estimated date and time for activity execution (with earliest possibility of activity initiation and latest possibility of activity completion).
 * @param requestedWindow Requested date and time interval for activity execution.
 * @param status [[ch.ninecode.model.Status Status]] <em>undocumented</em>
 * @param InspectionDataSet [[ch.ninecode.model.InspectionDataSet InspectionDataSet]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class ScheduledEventData
(
    override val sup: BasicElement,
    estimatedWindow: String,
    requestedWindow: String,
    status: String,
    InspectionDataSet: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEventData] }
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
        implicit val clz: String = ScheduledEventData.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ScheduledEventData.fields (position), value)
        emitattr (0, estimatedWindow)
        emitattr (1, requestedWindow)
        emitattr (2, status)
        emitattr (3, InspectionDataSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledEventData rdf:ID=\"%s\">\n%s\t</cim:ScheduledEventData>".format (id, export_fields)
    }
}

object ScheduledEventData
extends
    Parseable[ScheduledEventData]
{
    val fields: Array[String] = Array[String] (
        "estimatedWindow",
        "requestedWindow",
        "status",
        "InspectionDataSet"
    )
    val estimatedWindow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val requestedWindow: Fielder = parse_attribute (attribute (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val InspectionDataSet: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ScheduledEventData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ScheduledEventData (
            BasicElement.parse (context),
            mask (estimatedWindow (), 0),
            mask (requestedWindow (), 1),
            mask (status (), 2),
            mask (InspectionDataSet (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("InspectionDataSet", "InspectionDataSet", false)
    )
}

/**
 * Current status information relevant to an entity.
 *
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time for which status 'value' applies.
 * @param reason Reason code or explanation for why an object went to the current status 'value'.
 * @param remark Pertinent information regarding the current 'value', as free form text.
 * @param value Status value at 'dateTime'; prior status changes may have been kept in instances of activity records associated with the object to which this status applies.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class Status
(
    override val sup: BasicElement,
    dateTime: String,
    reason: String,
    remark: String,
    value: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Status] }
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
        implicit val clz: String = Status.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Status.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, reason)
        emitelem (2, remark)
        emitelem (3, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Status rdf:ID=\"%s\">\n%s\t</cim:Status>".format (id, export_fields)
    }
}

object Status
extends
    Parseable[Status]
{
    val fields: Array[String] = Array[String] (
        "dateTime",
        "reason",
        "remark",
        "value"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_element (element (cls, fields(1)))
    val remark: Fielder = parse_element (element (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): Status =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Status (
            BasicElement.parse (context),
            mask (dateTime (), 0),
            mask (reason (), 1),
            mask (remark (), 2),
            mask (value (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * General purpose street address information.
 *
 * @param sup Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this address.
 * @param streetDetail [[ch.ninecode.model.StreetDetail StreetDetail]] Street detail.
 * @param townDetail [[ch.ninecode.model.TownDetail TownDetail]] Town detail.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class StreetAddress
(
    override val sup: BasicElement,
    status: String,
    streetDetail: String,
    townDetail: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetAddress] }
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
        implicit val clz: String = StreetAddress.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StreetAddress.fields (position), value)
        emitattr (0, status)
        emitattr (1, streetDetail)
        emitattr (2, townDetail)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StreetAddress rdf:ID=\"%s\">\n%s\t</cim:StreetAddress>".format (id, export_fields)
    }
}

object StreetAddress
extends
    Parseable[StreetAddress]
{
    val fields: Array[String] = Array[String] (
        "status",
        "streetDetail",
        "townDetail"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val streetDetail: Fielder = parse_attribute (attribute (cls, fields(1)))
    val townDetail: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): StreetAddress =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StreetAddress (
            BasicElement.parse (context),
            mask (status (), 0),
            mask (streetDetail (), 1),
            mask (townDetail (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("streetDetail", "StreetDetail", false),
        Relationship ("townDetail", "TownDetail", false)
    )
}

/**
 * Street details, in the context of address.
 *
 * @param sup Reference to the superclass object.
 * @param addressGeneral Additional address information, for example a mailstop.
 * @param buildingName (if applicable) In certain cases the physical location of the place of interest does not have a direct point of entry from the street, but may be located inside a larger structure such as a building, complex, office block, apartment, etc.
 * @param code (if applicable) Utilities often make use of external reference systems, such as those of the town-planner's department or surveyor general's mapping system, that allocate global reference codes to streets.
 * @param name Name of the street.
 * @param number Designator of the specific location on the street.
 * @param prefix Prefix to the street name.
 *        For example: North, South, East, West.
 * @param suffix Suffix to the street name.
 *        For example: North, South, East, West.
 * @param suiteNumber Number of the apartment or suite.
 * @param withinTownLimits True if this street is within the legal geographical boundaries of the specified town (default).
 * @param `type` Type of street.
 *        Examples include: street, circle, boulevard, avenue, road, drive, etc.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class StreetDetail
(
    override val sup: BasicElement,
    addressGeneral: String,
    buildingName: String,
    code: String,
    name: String,
    number: String,
    prefix: String,
    suffix: String,
    suiteNumber: String,
    withinTownLimits: Boolean,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetDetail] }
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
        implicit val clz: String = StreetDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StreetDetail.fields (position), value)
        emitelem (0, addressGeneral)
        emitelem (1, buildingName)
        emitelem (2, code)
        emitelem (3, name)
        emitelem (4, number)
        emitelem (5, prefix)
        emitelem (6, suffix)
        emitelem (7, suiteNumber)
        emitelem (8, withinTownLimits)
        emitelem (9, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StreetDetail rdf:ID=\"%s\">\n%s\t</cim:StreetDetail>".format (id, export_fields)
    }
}

object StreetDetail
extends
    Parseable[StreetDetail]
{
    val fields: Array[String] = Array[String] (
        "addressGeneral",
        "buildingName",
        "code",
        "name",
        "number",
        "prefix",
        "suffix",
        "suiteNumber",
        "withinTownLimits",
        "type"
    )
    val addressGeneral: Fielder = parse_element (element (cls, fields(0)))
    val buildingName: Fielder = parse_element (element (cls, fields(1)))
    val code: Fielder = parse_element (element (cls, fields(2)))
    val name: Fielder = parse_element (element (cls, fields(3)))
    val number: Fielder = parse_element (element (cls, fields(4)))
    val prefix: Fielder = parse_element (element (cls, fields(5)))
    val suffix: Fielder = parse_element (element (cls, fields(6)))
    val suiteNumber: Fielder = parse_element (element (cls, fields(7)))
    val withinTownLimits: Fielder = parse_element (element (cls, fields(8)))
    val `type`: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): StreetDetail =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StreetDetail (
            BasicElement.parse (context),
            mask (addressGeneral (), 0),
            mask (buildingName (), 1),
            mask (code (), 2),
            mask (name (), 3),
            mask (number (), 4),
            mask (prefix (), 5),
            mask (suffix (), 6),
            mask (suiteNumber (), 7),
            toBoolean (mask (withinTownLimits (), 8)),
            mask (`type` (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Telephone number.
 *
 * @param sup Reference to the superclass object.
 * @param areaCode Area or region code.
 * @param cityCode (if applicable) City code.
 * @param countryCode Country code.
 * @param extension (if applicable) Extension for this telephone number.
 * @param localNumber Main (local) part of this telephone number.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class TelephoneNumber
(
    override val sup: BasicElement,
    areaCode: String,
    cityCode: String,
    countryCode: String,
    extension: String,
    localNumber: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TelephoneNumber] }
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
        implicit val clz: String = TelephoneNumber.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TelephoneNumber.fields (position), value)
        emitelem (0, areaCode)
        emitelem (1, cityCode)
        emitelem (2, countryCode)
        emitelem (3, extension)
        emitelem (4, localNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TelephoneNumber rdf:ID=\"%s\">\n%s\t</cim:TelephoneNumber>".format (id, export_fields)
    }
}

object TelephoneNumber
extends
    Parseable[TelephoneNumber]
{
    val fields: Array[String] = Array[String] (
        "areaCode",
        "cityCode",
        "countryCode",
        "extension",
        "localNumber"
    )
    val areaCode: Fielder = parse_element (element (cls, fields(0)))
    val cityCode: Fielder = parse_element (element (cls, fields(1)))
    val countryCode: Fielder = parse_element (element (cls, fields(2)))
    val extension: Fielder = parse_element (element (cls, fields(3)))
    val localNumber: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): TelephoneNumber =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TelephoneNumber (
            BasicElement.parse (context),
            mask (areaCode (), 0),
            mask (cityCode (), 1),
            mask (countryCode (), 2),
            mask (extension (), 3),
            mask (localNumber (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A point in time within a sequence of points in time relative to a time schedule.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dateTime Absolute date and time for this time point.
 *        For calendar-based time point, it is typically manually entered, while for interval-based or sequence-based time point it is derived.
 * @param relativeTimeInterval (if interval-based) A point in time relative to scheduled start time in 'TimeSchedule.scheduleInterval.start'.
 * @param sequenceNumber (if sequence-based) Relative sequence number for this time point.
 * @param status [[ch.ninecode.model.Status Status]] Status of this time point.
 * @param window Interval defining the window of time that this time point is valid (for example, seasonal, only on weekends, not on weekends, only 8:00 am to 5:00 pm, etc.).
 * @param TimeSchedule [[ch.ninecode.model.TimeSchedule TimeSchedule]] Time schedule owning this time point.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class TimePoint
(
    override val sup: IdentifiedObject,
    dateTime: String,
    relativeTimeInterval: Double,
    sequenceNumber: Int,
    status: String,
    window: String,
    TimeSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TimePoint] }
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
        implicit val clz: String = TimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimePoint.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, relativeTimeInterval)
        emitelem (2, sequenceNumber)
        emitattr (3, status)
        emitattr (4, window)
        emitattr (5, TimeSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimePoint rdf:ID=\"%s\">\n%s\t</cim:TimePoint>".format (id, export_fields)
    }
}

object TimePoint
extends
    Parseable[TimePoint]
{
    val fields: Array[String] = Array[String] (
        "dateTime",
        "relativeTimeInterval",
        "sequenceNumber",
        "status",
        "window",
        "TimeSchedule"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val relativeTimeInterval: Fielder = parse_element (element (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val window: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimeSchedule: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TimePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TimePoint (
            IdentifiedObject.parse (context),
            mask (dateTime (), 0),
            toDouble (mask (relativeTimeInterval (), 1)),
            toInteger (mask (sequenceNumber (), 2)),
            mask (status (), 3),
            mask (window (), 4),
            mask (TimeSchedule (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("status", "Status", false),
        Relationship ("TimeSchedule", "TimeSchedule", false)
    )
}

/**
 * Description of anything that changes through time.
 *
 * Time schedule is used to perform a single-valued function of time. Use inherited 'type' attribute to give additional information on this schedule, such as: periodic (hourly, daily, weekly, monthly, etc.), day of the month, by date, calendar (specific times and dates).
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param disabled True if this schedule is deactivated (disabled).
 * @param offset The offset from midnight (i.e., 0 h, 0 min, 0 s) for the periodic time points to begin.
 *        For example, for an interval meter that is set up for five minute intervals ('recurrencePeriod'=300=5 min), setting 'offset'=120=2 min would result in scheduled events to read the meter executing at 2 min, 7 min, 12 min, 17 min, 22 min, 27 min, 32 min, 37 min, 42 min, 47 min, 52 min, and 57 min past each hour.
 * @param recurrencePattern Interval at which the scheduled action repeats (e.g., first Monday of every month, last day of the month, etc.).
 * @param recurrencePeriod Duration between time points, from the beginning of one period to the beginning of the next period.
 *        Note that a device like a meter may have multiple interval periods (e.g., 1 min, 5 min, 15 min, 30 min, or 60 min).
 * @param scheduleInterval Schedule date and time interval.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class TimeSchedule
(
    override val sup: Document,
    disabled: Boolean,
    offset: Double,
    recurrencePattern: String,
    recurrencePeriod: Double,
    scheduleInterval: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[TimeSchedule] }
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
        implicit val clz: String = TimeSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimeSchedule.fields (position), value)
        emitelem (0, disabled)
        emitelem (1, offset)
        emitelem (2, recurrencePattern)
        emitelem (3, recurrencePeriod)
        emitattr (4, scheduleInterval)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeSchedule rdf:ID=\"%s\">\n%s\t</cim:TimeSchedule>".format (id, export_fields)
    }
}

object TimeSchedule
extends
    Parseable[TimeSchedule]
{
    val fields: Array[String] = Array[String] (
        "disabled",
        "offset",
        "recurrencePattern",
        "recurrencePeriod",
        "scheduleInterval"
    )
    val disabled: Fielder = parse_element (element (cls, fields(0)))
    val offset: Fielder = parse_element (element (cls, fields(1)))
    val recurrencePattern: Fielder = parse_element (element (cls, fields(2)))
    val recurrencePeriod: Fielder = parse_element (element (cls, fields(3)))
    val scheduleInterval: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): TimeSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TimeSchedule (
            Document.parse (context),
            toBoolean (mask (disabled (), 0)),
            toDouble (mask (offset (), 1)),
            mask (recurrencePattern (), 2),
            toDouble (mask (recurrencePeriod (), 3)),
            mask (scheduleInterval (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Town details, in the context of address.
 *
 * @param sup Reference to the superclass object.
 * @param code Town code.
 * @param country Name of the country.
 * @param name Town name.
 * @param section Town section.
 *        For example, it is common for there to be 36 sections per township.
 * @param stateOrProvince Name of the state or province.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class TownDetail
(
    override val sup: BasicElement,
    code: String,
    country: String,
    name: String,
    section: String,
    stateOrProvince: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TownDetail] }
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
        implicit val clz: String = TownDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TownDetail.fields (position), value)
        emitelem (0, code)
        emitelem (1, country)
        emitelem (2, name)
        emitelem (3, section)
        emitelem (4, stateOrProvince)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TownDetail rdf:ID=\"%s\">\n%s\t</cim:TownDetail>".format (id, export_fields)
    }
}

object TownDetail
extends
    Parseable[TownDetail]
{
    val fields: Array[String] = Array[String] (
        "code",
        "country",
        "name",
        "section",
        "stateOrProvince"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val country: Fielder = parse_element (element (cls, fields(1)))
    val name: Fielder = parse_element (element (cls, fields(2)))
    val section: Fielder = parse_element (element (cls, fields(3)))
    val stateOrProvince: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): TownDetail =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TownDetail (
            BasicElement.parse (context),
            mask (code (), 0),
            mask (country (), 1),
            mask (name (), 2),
            mask (section (), 3),
            mask (stateOrProvince (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Generic name-value pair class, with optional sequence number and units for value; can be used to model parts of information exchange when concrete types are not known in advance.
 *
 * @param sup Reference to the superclass object.
 * @param name Name of an attribute.
 * @param sequenceNumber Sequence number for this attribute in a list of attributes.
 * @param value Value of an attribute, including unit information.
 * @param ErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpLedgerEntries [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param PropertySpecification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param RatingSpecification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param Transaction [[ch.ninecode.model.Transaction Transaction]] Transaction for which this snapshot has been recorded.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
case class UserAttribute
(
    override val sup: BasicElement,
    name: String,
    sequenceNumber: Int,
    value: String,
    ErpInvoiceLineItems: List[String],
    ErpLedgerEntries: List[String],
    ProcedureDataSets: List[String],
    PropertySpecification: String,
    RatingSpecification: String,
    Transaction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, List(), List(), List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UserAttribute] }
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
        implicit val clz: String = UserAttribute.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UserAttribute.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UserAttribute.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (UserAttribute.fields (position), x))
        emitelem (0, name)
        emitelem (1, sequenceNumber)
        emitattr (2, value)
        emitattrs (3, ErpInvoiceLineItems)
        emitattrs (4, ErpLedgerEntries)
        emitattrs (5, ProcedureDataSets)
        emitattr (6, PropertySpecification)
        emitattr (7, RatingSpecification)
        emitattr (8, Transaction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UserAttribute rdf:ID=\"%s\">\n%s\t</cim:UserAttribute>".format (id, export_fields)
    }
}

object UserAttribute
extends
    Parseable[UserAttribute]
{
    val fields: Array[String] = Array[String] (
        "name",
        "sequenceNumber",
        "value",
        "ErpInvoiceLineItems",
        "ErpLedgerEntries",
        "ProcedureDataSets",
        "PropertySpecification",
        "RatingSpecification",
        "Transaction"
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val value: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpInvoiceLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ErpLedgerEntries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PropertySpecification: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RatingSpecification: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Transaction: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): UserAttribute =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UserAttribute (
            BasicElement.parse (context),
            mask (name (), 0),
            toInteger (mask (sequenceNumber (), 1)),
            mask (value (), 2),
            masks (ErpInvoiceLineItems (), 3),
            masks (ErpLedgerEntries (), 4),
            masks (ProcedureDataSets (), 5),
            mask (PropertySpecification (), 6),
            mask (RatingSpecification (), 7),
            mask (Transaction (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItems", "ErpInvoiceLineItem", true),
        Relationship ("ErpLedgerEntries", "ErpLedgerEntry", true),
        Relationship ("ProcedureDataSets", "ProcedureDataSet", true),
        Relationship ("PropertySpecification", "Specification", false),
        Relationship ("RatingSpecification", "Specification", false),
        Relationship ("Transaction", "Transaction", false)
    )
}

private[ninecode] object _Common
{
    def register: List[ClassInfo] =
    {
        List (
            ActivityRecord.register,
            Agreement.register,
            Appointment.register,
            ConfigurationEvent.register,
            CoordinateSystem.register,
            Crew.register,
            CrewMember.register,
            CrewType.register,
            Document.register,
            ElectronicAddress.register,
            Hazard.register,
            Location.register,
            OperationPersonRole.register,
            Operator.register,
            Organisation.register,
            OrganisationRole.register,
            Ownership.register,
            Person.register,
            PersonRole.register,
            PositionPoint.register,
            PostalAddress.register,
            Priority.register,
            ScheduledEvent.register,
            ScheduledEventData.register,
            Status.register,
            StreetAddress.register,
            StreetDetail.register,
            TelephoneNumber.register,
            TimePoint.register,
            TimeSchedule.register,
            TownDetail.register,
            UserAttribute.register
        )
    }
}