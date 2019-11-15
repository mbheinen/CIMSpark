package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Combustion turbine air compressor which is an integral part of a compressed air energy storage (CAES) plant.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param airCompressorRating Rating of the CAES air compressor.
 * @param CAESPlant [[ch.ninecode.model.CAESPlant CAESPlant]] An air compressor may be a member of a compressed air energy storage plant.
 * @param CombustionTurbine [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A CAES air compressor is driven by combustion turbine.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class AirCompressor
(
    override val sup: PowerSystemResource = null,
    airCompressorRating: Double = 0.0,
    CAESPlant: String = null,
    CombustionTurbine: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[AirCompressor] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AirCompressor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AirCompressor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AirCompressor.fields (position), value)
        emitelem (0, airCompressorRating)
        emitattr (1, CAESPlant)
        emitattr (2, CombustionTurbine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AirCompressor rdf:ID=\"%s\">\n%s\t</cim:AirCompressor>".format (id, export_fields)
    }
}

object AirCompressor
extends
    Parseable[AirCompressor]
{
    override val fields: Array[String] = Array[String] (
        "airCompressorRating",
        "CAESPlant",
        "CombustionTurbine"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CAESPlant", "CAESPlant", "1", "1"),
        Relationship ("CombustionTurbine", "CombustionTurbine", "1", "0..1")
    )
    val airCompressorRating: Fielder = parse_element (element (cls, fields(0)))
    val CAESPlant: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CombustionTurbine: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AirCompressor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AirCompressor (
            PowerSystemResource.parse (context),
            toDouble (mask (airCompressorRating (), 0)),
            mask (CAESPlant (), 1),
            mask (CombustionTurbine (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrochemical energy storage device.
 *
 * @param sup [[ch.ninecode.model.PowerElectronicsUnit PowerElectronicsUnit]] Reference to the superclass object.
 * @param batteryState The current state of the battery (charging, full, etc.).
 * @param ratedE Full energy storage capacity of the battery.
 * @param storedE Amount of energy currently stored; no more than ratedE.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class BatteryUnit
(
    override val sup: PowerElectronicsUnit = null,
    batteryState: String = null,
    ratedE: Double = 0.0,
    storedE: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerElectronicsUnit: PowerElectronicsUnit = sup.asInstanceOf[PowerElectronicsUnit]
    override def copy (): Row = { clone ().asInstanceOf[BatteryUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BatteryUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BatteryUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BatteryUnit.fields (position), value)
        emitattr (0, batteryState)
        emitelem (1, ratedE)
        emitelem (2, storedE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BatteryUnit rdf:ID=\"%s\">\n%s\t</cim:BatteryUnit>".format (id, export_fields)
    }
}

object BatteryUnit
extends
    Parseable[BatteryUnit]
{
    override val fields: Array[String] = Array[String] (
        "batteryState",
        "ratedE",
        "storedE"
    )
    val batteryState: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ratedE: Fielder = parse_element (element (cls, fields(1)))
    val storedE: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): BatteryUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BatteryUnit (
            PowerElectronicsUnit.parse (context),
            mask (batteryState (), 0),
            toDouble (mask (ratedE (), 1)),
            toDouble (mask (storedE (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Compressed air energy storage plant.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param energyStorageCapacity The rated energy storage capacity.
 * @param ratedCapacityP The CAES plant's gross rated generating capacity.
 * @param AirCompressor [[ch.ninecode.model.AirCompressor AirCompressor]] An air compressor may be a member of a compressed air energy storage plant.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may be a member of a compressed air energy storage plant.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class CAESPlant
(
    override val sup: PowerSystemResource = null,
    energyStorageCapacity: Double = 0.0,
    ratedCapacityP: Double = 0.0,
    AirCompressor: String = null,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CAESPlant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CAESPlant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CAESPlant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CAESPlant.fields (position), value)
        emitelem (0, energyStorageCapacity)
        emitelem (1, ratedCapacityP)
        emitattr (2, AirCompressor)
        emitattr (3, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CAESPlant rdf:ID=\"%s\">\n%s\t</cim:CAESPlant>".format (id, export_fields)
    }
}

object CAESPlant
extends
    Parseable[CAESPlant]
{
    override val fields: Array[String] = Array[String] (
        "energyStorageCapacity",
        "ratedCapacityP",
        "AirCompressor",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AirCompressor", "AirCompressor", "1", "1"),
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "0..1", "0..1")
    )
    val energyStorageCapacity: Fielder = parse_element (element (cls, fields(0)))
    val ratedCapacityP: Fielder = parse_element (element (cls, fields(1)))
    val AirCompressor: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): CAESPlant =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CAESPlant (
            PowerSystemResource.parse (context),
            toDouble (mask (energyStorageCapacity (), 0)),
            toDouble (mask (ratedCapacityP (), 1)),
            mask (AirCompressor (), 2),
            mask (ThermalGeneratingUnit (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A set of thermal generating units for the production of electrical energy and process steam (usually from the output of the steam turbines).
 *
 * The steam sendout is typically used for industrial purposes or for municipal heating and cooling.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param cogenHPSendoutRating The high pressure steam sendout.
 * @param cogenHPSteamRating The high pressure steam rating.
 * @param cogenLPSendoutRating The low pressure steam sendout.
 * @param cogenLPSteamRating The low pressure steam rating.
 * @param ratedP The rated output active power of the cogeneration plant.
 * @param SteamSendoutSchedule [[ch.ninecode.model.SteamSendoutSchedule SteamSendoutSchedule]] A cogeneration plant has a steam sendout schedule.
 * @param ThermalGeneratingUnits [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may be a member of a cogeneration plant.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class CogenerationPlant
(
    override val sup: PowerSystemResource = null,
    cogenHPSendoutRating: Double = 0.0,
    cogenHPSteamRating: Double = 0.0,
    cogenLPSendoutRating: Double = 0.0,
    cogenLPSteamRating: Double = 0.0,
    ratedP: Double = 0.0,
    SteamSendoutSchedule: String = null,
    ThermalGeneratingUnits: List[String] = List()
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CogenerationPlant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CogenerationPlant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CogenerationPlant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CogenerationPlant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CogenerationPlant.fields (position), x))
        emitelem (0, cogenHPSendoutRating)
        emitelem (1, cogenHPSteamRating)
        emitelem (2, cogenLPSendoutRating)
        emitelem (3, cogenLPSteamRating)
        emitelem (4, ratedP)
        emitattr (5, SteamSendoutSchedule)
        emitattrs (6, ThermalGeneratingUnits)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CogenerationPlant rdf:ID=\"%s\">\n%s\t</cim:CogenerationPlant>".format (id, export_fields)
    }
}

object CogenerationPlant
extends
    Parseable[CogenerationPlant]
{
    override val fields: Array[String] = Array[String] (
        "cogenHPSendoutRating",
        "cogenHPSteamRating",
        "cogenLPSendoutRating",
        "cogenLPSteamRating",
        "ratedP",
        "SteamSendoutSchedule",
        "ThermalGeneratingUnits"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SteamSendoutSchedule", "SteamSendoutSchedule", "1", "1"),
        Relationship ("ThermalGeneratingUnits", "ThermalGeneratingUnit", "0..*", "0..1")
    )
    val cogenHPSendoutRating: Fielder = parse_element (element (cls, fields(0)))
    val cogenHPSteamRating: Fielder = parse_element (element (cls, fields(1)))
    val cogenLPSendoutRating: Fielder = parse_element (element (cls, fields(2)))
    val cogenLPSteamRating: Fielder = parse_element (element (cls, fields(3)))
    val ratedP: Fielder = parse_element (element (cls, fields(4)))
    val SteamSendoutSchedule: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ThermalGeneratingUnits: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): CogenerationPlant =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CogenerationPlant (
            PowerSystemResource.parse (context),
            toDouble (mask (cogenHPSendoutRating (), 0)),
            toDouble (mask (cogenHPSteamRating (), 1)),
            toDouble (mask (cogenLPSendoutRating (), 2)),
            toDouble (mask (cogenLPSteamRating (), 3)),
            toDouble (mask (ratedP (), 4)),
            mask (SteamSendoutSchedule (), 5),
            masks (ThermalGeneratingUnits (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param combCyclePlantRating The combined cycle plant's active power output rating.
 * @param ThermalGeneratingUnits [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may be a member of a combined cycle plant.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class CombinedCyclePlant
(
    override val sup: PowerSystemResource = null,
    combCyclePlantRating: Double = 0.0,
    ThermalGeneratingUnits: List[String] = List()
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCyclePlant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombinedCyclePlant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombinedCyclePlant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CombinedCyclePlant.fields (position), x))
        emitelem (0, combCyclePlantRating)
        emitattrs (1, ThermalGeneratingUnits)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCyclePlant rdf:ID=\"%s\">\n%s\t</cim:CombinedCyclePlant>".format (id, export_fields)
    }
}

object CombinedCyclePlant
extends
    Parseable[CombinedCyclePlant]
{
    override val fields: Array[String] = Array[String] (
        "combCyclePlantRating",
        "ThermalGeneratingUnits"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnits", "ThermalGeneratingUnit", "0..*", "0..1")
    )
    val combCyclePlantRating: Fielder = parse_element (element (cls, fields(0)))
    val ThermalGeneratingUnits: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): CombinedCyclePlant =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CombinedCyclePlant (
            PowerSystemResource.parse (context),
            toDouble (mask (combCyclePlantRating (), 0)),
            masks (ThermalGeneratingUnits (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Accounts for tracking emissions usage and credits for thermal generating units.
 *
 * A unit may have zero or more emission accounts, and will typically have one for tracking usage and one for tracking credits.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param emissionType The type of emission, for example sulfur dioxide (SO2).
 *        The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfur dioxide).
 * @param emissionValueSource The source of the emission value.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have one or more emission allowance accounts.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class EmissionAccount
(
    override val sup: Curve = null,
    emissionType: String = null,
    emissionValueSource: String = null,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[EmissionAccount] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EmissionAccount.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EmissionAccount.fields (position), value)
        emitattr (0, emissionType)
        emitattr (1, emissionValueSource)
        emitattr (2, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EmissionAccount rdf:ID=\"%s\">\n%s\t</cim:EmissionAccount>".format (id, export_fields)
    }
}

object EmissionAccount
extends
    Parseable[EmissionAccount]
{
    override val fields: Array[String] = Array[String] (
        "emissionType",
        "emissionValueSource",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..*")
    )
    val emissionType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val emissionValueSource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): EmissionAccount =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EmissionAccount (
            Curve.parse (context),
            mask (emissionType (), 0),
            mask (emissionValueSource (), 1),
            mask (ThermalGeneratingUnit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between the unit's emission rate in units of mass per hour (Y-axis) and output active power (X-axis) for a given type of emission.
 *
 * This curve applies when only one type of fuel is being burned.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param emissionContent The emission content per quantity of fuel burned.
 * @param emissionType The type of emission, which also gives the production rate measurement unit.
 *        The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfur dioxide).
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have  one or more emission curves.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class EmissionCurve
(
    override val sup: Curve = null,
    emissionContent: Double = 0.0,
    emissionType: String = null,
    isNetGrossP: Boolean = false,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[EmissionCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EmissionCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EmissionCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EmissionCurve.fields (position), value)
        emitelem (0, emissionContent)
        emitattr (1, emissionType)
        emitelem (2, isNetGrossP)
        emitattr (3, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EmissionCurve rdf:ID=\"%s\">\n%s\t</cim:EmissionCurve>".format (id, export_fields)
    }
}

object EmissionCurve
extends
    Parseable[EmissionCurve]
{
    override val fields: Array[String] = Array[String] (
        "emissionContent",
        "emissionType",
        "isNetGrossP",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..*")
    )
    val emissionContent: Fielder = parse_element (element (cls, fields(0)))
    val emissionType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val isNetGrossP: Fielder = parse_element (element (cls, fields(2)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): EmissionCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EmissionCurve (
            Curve.parse (context),
            toDouble (mask (emissionContent (), 0)),
            mask (emissionType (), 1),
            toBoolean (mask (isNetGrossP (), 2)),
            mask (ThermalGeneratingUnit (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The fossil fuel consumed by the non-nuclear thermal generating unit.
 *
 * For example, coal, oil, gas, etc.   These are the specific fuels that the generating unit can consume.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fossilFuelType The type of fossil fuel, such as coal, oil, or gas.
 * @param fuelCost The cost in terms of heat value for the given type of fuel.
 * @param fuelDispatchCost The cost of fuel used for economic dispatching which includes: fuel cost, transportation cost,  and incremental maintenance cost.
 * @param fuelEffFactor The efficiency factor for the fuel (per unit) in terms of the effective energy absorbed.
 * @param fuelHandlingCost Handling and processing cost associated with this fuel.
 * @param fuelHeatContent The amount of heat per weight (or volume) of the given type of fuel.
 * @param fuelMixture Relative amount of the given type of fuel, when multiple fuels are being consumed.
 * @param fuelSulfur The fuel's fraction of pollution credit per unit of heat content.
 * @param highBreakpointP The active power output level of the unit at which the given type of fuel is switched on.
 *        This fuel (e.g., oil) is sometimes used to supplement the base fuel (e.g., coal) at high active power output levels.
 * @param lowBreakpointP The active power output level of the unit at which the given type of fuel is switched off.
 *        This fuel (e.g., oil) is sometimes used to stabilize the base fuel (e.g., coal) at low active power output levels.
 * @param FuelAllocationSchedules [[ch.ninecode.model.FuelAllocationSchedule FuelAllocationSchedule]] A fuel allocation schedule shall have a fossil fuel.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have one or more fossil fuels.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class FossilFuel
(
    override val sup: IdentifiedObject = null,
    fossilFuelType: String = null,
    fuelCost: Double = 0.0,
    fuelDispatchCost: Double = 0.0,
    fuelEffFactor: Double = 0.0,
    fuelHandlingCost: Double = 0.0,
    fuelHeatContent: Double = 0.0,
    fuelMixture: Double = 0.0,
    fuelSulfur: Double = 0.0,
    highBreakpointP: Double = 0.0,
    lowBreakpointP: Double = 0.0,
    FuelAllocationSchedules: List[String] = List(),
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FossilFuel] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FossilFuel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FossilFuel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FossilFuel.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FossilFuel.fields (position), x))
        emitattr (0, fossilFuelType)
        emitelem (1, fuelCost)
        emitelem (2, fuelDispatchCost)
        emitelem (3, fuelEffFactor)
        emitelem (4, fuelHandlingCost)
        emitelem (5, fuelHeatContent)
        emitelem (6, fuelMixture)
        emitelem (7, fuelSulfur)
        emitelem (8, highBreakpointP)
        emitelem (9, lowBreakpointP)
        emitattrs (10, FuelAllocationSchedules)
        emitattr (11, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FossilFuel rdf:ID=\"%s\">\n%s\t</cim:FossilFuel>".format (id, export_fields)
    }
}

object FossilFuel
extends
    Parseable[FossilFuel]
{
    override val fields: Array[String] = Array[String] (
        "fossilFuelType",
        "fuelCost",
        "fuelDispatchCost",
        "fuelEffFactor",
        "fuelHandlingCost",
        "fuelHeatContent",
        "fuelMixture",
        "fuelSulfur",
        "highBreakpointP",
        "lowBreakpointP",
        "FuelAllocationSchedules",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FuelAllocationSchedules", "FuelAllocationSchedule", "0..*", "1"),
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..*")
    )
    val fossilFuelType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val fuelCost: Fielder = parse_element (element (cls, fields(1)))
    val fuelDispatchCost: Fielder = parse_element (element (cls, fields(2)))
    val fuelEffFactor: Fielder = parse_element (element (cls, fields(3)))
    val fuelHandlingCost: Fielder = parse_element (element (cls, fields(4)))
    val fuelHeatContent: Fielder = parse_element (element (cls, fields(5)))
    val fuelMixture: Fielder = parse_element (element (cls, fields(6)))
    val fuelSulfur: Fielder = parse_element (element (cls, fields(7)))
    val highBreakpointP: Fielder = parse_element (element (cls, fields(8)))
    val lowBreakpointP: Fielder = parse_element (element (cls, fields(9)))
    val FuelAllocationSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): FossilFuel =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FossilFuel (
            IdentifiedObject.parse (context),
            mask (fossilFuelType (), 0),
            toDouble (mask (fuelCost (), 1)),
            toDouble (mask (fuelDispatchCost (), 2)),
            toDouble (mask (fuelEffFactor (), 3)),
            toDouble (mask (fuelHandlingCost (), 4)),
            toDouble (mask (fuelHeatContent (), 5)),
            toDouble (mask (fuelMixture (), 6)),
            toDouble (mask (fuelSulfur (), 7)),
            toDouble (mask (highBreakpointP (), 8)),
            toDouble (mask (lowBreakpointP (), 9)),
            masks (FuelAllocationSchedules (), 10),
            mask (ThermalGeneratingUnit (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The amount of fuel of a given type which is allocated for consumption over a specified period of time.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param fuelAllocationEndDate The end time and date of the fuel allocation schedule.
 * @param fuelAllocationStartDate The start time and date of the fuel allocation schedule.
 * @param fuelType The type of fuel, which also indicates the corresponding measurement unit.
 * @param maxFuelAllocation The maximum amount of fuel that is allocated for consumption for the scheduled time period.
 * @param minFuelAllocation The minimum amount of fuel that is allocated for consumption for the scheduled time period, e.g., based on a "take-or-pay" contract.
 * @param FossilFuel [[ch.ninecode.model.FossilFuel FossilFuel]] A fuel allocation schedule shall have a fossil fuel.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have one or more fuel allocation schedules.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class FuelAllocationSchedule
(
    override val sup: Curve = null,
    fuelAllocationEndDate: String = null,
    fuelAllocationStartDate: String = null,
    fuelType: String = null,
    maxFuelAllocation: Double = 0.0,
    minFuelAllocation: Double = 0.0,
    FossilFuel: String = null,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[FuelAllocationSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FuelAllocationSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FuelAllocationSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelAllocationSchedule.fields (position), value)
        emitelem (0, fuelAllocationEndDate)
        emitelem (1, fuelAllocationStartDate)
        emitattr (2, fuelType)
        emitelem (3, maxFuelAllocation)
        emitelem (4, minFuelAllocation)
        emitattr (5, FossilFuel)
        emitattr (6, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FuelAllocationSchedule rdf:ID=\"%s\">\n%s\t</cim:FuelAllocationSchedule>".format (id, export_fields)
    }
}

object FuelAllocationSchedule
extends
    Parseable[FuelAllocationSchedule]
{
    override val fields: Array[String] = Array[String] (
        "fuelAllocationEndDate",
        "fuelAllocationStartDate",
        "fuelType",
        "maxFuelAllocation",
        "minFuelAllocation",
        "FossilFuel",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FossilFuel", "FossilFuel", "1", "0..*"),
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..*")
    )
    val fuelAllocationEndDate: Fielder = parse_element (element (cls, fields(0)))
    val fuelAllocationStartDate: Fielder = parse_element (element (cls, fields(1)))
    val fuelType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val maxFuelAllocation: Fielder = parse_element (element (cls, fields(3)))
    val minFuelAllocation: Fielder = parse_element (element (cls, fields(4)))
    val FossilFuel: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): FuelAllocationSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FuelAllocationSchedule (
            Curve.parse (context),
            mask (fuelAllocationEndDate (), 0),
            mask (fuelAllocationStartDate (), 1),
            mask (fuelType (), 2),
            toDouble (mask (maxFuelAllocation (), 3)),
            toDouble (mask (minFuelAllocation (), 4)),
            mask (FossilFuel (), 5),
            mask (ThermalGeneratingUnit (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit operating cost (Y-axis) and unit output active power (X-axis).
 *
 * The operating cost curve for thermal units is derived from heat input and fuel costs. The operating cost curve for hydro units is derived from water flow rates and equivalent water costs.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] A generating unit may have one or more cost curves, depending upon fuel mixture and fuel cost.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class GenUnitOpCostCurve
(
    override val sup: Curve = null,
    isNetGrossP: Boolean = false,
    GeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[GenUnitOpCostCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenUnitOpCostCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenUnitOpCostCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenUnitOpCostCurve.fields (position), value)
        emitelem (0, isNetGrossP)
        emitattr (1, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenUnitOpCostCurve rdf:ID=\"%s\">\n%s\t</cim:GenUnitOpCostCurve>".format (id, export_fields)
    }
}

object GenUnitOpCostCurve
extends
    Parseable[GenUnitOpCostCurve]
{
    override val fields: Array[String] = Array[String] (
        "isNetGrossP",
        "GeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "GeneratingUnit", "1", "0..*")
    )
    val isNetGrossP: Fielder = parse_element (element (cls, fields(0)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): GenUnitOpCostCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenUnitOpCostCurve (
            Curve.parse (context),
            toBoolean (mask (isNetGrossP (), 0)),
            mask (GeneratingUnit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The generating unit's Operator-approved current operating schedule (or plan), typically produced with the aid of unit commitment type analyses.
 *
 * The X-axis represents absolute time. The Y1-axis represents the status (0=off-line and unavailable: 1=available: 2=must run: 3=must run at fixed power value: etc.). The Y2-axis represents the must run fixed power value where required.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] A generating unit may have an operating schedule, indicating the planned operation of the unit.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class GenUnitOpSchedule
(
    override val sup: RegularIntervalSchedule = null,
    GeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[GenUnitOpSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenUnitOpSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenUnitOpSchedule.fields (position), value)
        emitattr (0, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenUnitOpSchedule rdf:ID=\"%s\">\n%s\t</cim:GenUnitOpSchedule>".format (id, export_fields)
    }
}

object GenUnitOpSchedule
extends
    Parseable[GenUnitOpSchedule]
{
    override val fields: Array[String] = Array[String] (
        "GeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "GeneratingUnit", "1", "0..1")
    )
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): GenUnitOpSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenUnitOpSchedule (
            RegularIntervalSchedule.parse (context),
            mask (GeneratingUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A single or set of synchronous machines for converting mechanical power into alternating-current power.
 *
 * For example, individual machines within a set may be defined for scheduling purposes while a single control signal is derived for the set. In this case there would be a GeneratingUnit for each member of the set and an additional GeneratingUnit corresponding to the set.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param allocSpinResP The planned unused capacity (spinning reserve) which can be used to support emergency load.
 * @param autoCntrlMarginP The planned unused capacity which can be used to support automatic control overruns.
 * @param baseP For dispatchable units, this value represents the economic active power basepoint, for units that are not dispatchable, this value represents the fixed generation value.
 *        The value shall be between the operating low and high limits.
 * @param controlDeadband Unit control error deadband.
 *        When a unit's desired active power change is less than this deadband, then no control pulses will be sent to the unit.
 * @param controlPulseHigh Pulse high limit which is the largest control pulse that the unit can respond to.
 * @param controlPulseLow Pulse low limit which is the smallest control pulse that the unit can respond to.
 * @param controlResponseRate Unit response rate which specifies the active power change for a control pulse of one second in the most responsive loading level of the unit.
 * @param efficiency The efficiency of the unit in converting mechanical energy, from the prime mover, into electrical energy.
 * @param genControlMode The unit control mode.
 * @param genControlSource The source of controls for a generating unit.
 *        Defines the control status of the generating unit.
 * @param governorMPL Governor motor position limit.
 * @param governorSCD Governor Speed Changer Droop.
 *        This is the change in generator power output divided by the change in frequency normalized by the nominal power of the generator and the nominal frequency and expressed in percent and negated. A positive value of speed change droop provides additional generator output upon a drop in frequency.
 * @param highControlLimit High limit for secondary (AGC) control.
 * @param initialP Default initial active power  which is used to store a powerflow result for the initial active power for this unit in this network configuration.
 * @param longPF Generating unit long term economic participation factor.
 * @param lowControlLimit Low limit for secondary (AGC) control.
 * @param lowerRampRate The normal maximum rate the generating unit active power output can be lowered by control actions.
 * @param maxEconomicP Maximum high economic active power limit, that should not exceed the maximum operating active power limit.
 * @param maxOperatingP This is the maximum operating active power limit the dispatcher can enter for this unit.
 * @param maximumAllowableSpinningReserve Maximum allowable spinning reserve.
 *        Spinning reserve will never be considered greater than this value regardless of the current operating point.
 * @param minEconomicP Low economic active power limit that shall be greater than or equal to the minimum operating active power limit.
 * @param minOperatingP This is the minimum operating active power limit the dispatcher can enter for this unit.
 * @param minimumOffTime Minimum time interval between unit shutdown and startup.
 * @param modelDetail Detail level of the generator model data.
 * @param nominalP The nominal power of the generating unit.
 *        Used to give precise meaning to percentage based attributes such as the governor speed change droop (governorSCD attribute).
 *        The attribute shall be a positive value equal to or less than RotatingMachine.ratedS.
 * @param normalPF Generating unit economic participation factor.
 *        The sum of the participation factors across generating units does not have to sum to one.  It is used for representing distributed slack participation factor.
 * @param penaltyFactor Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value.
 *        The typical range of penalty factors is (0.9 to 1.1).
 * @param raiseRampRate The normal maximum rate the generating unit active power output can be raised by control actions.
 * @param ratedGrossMaxP The unit's gross rated maximum capacity (book value).
 * @param ratedGrossMinP The gross rated minimum generation level which the unit can safely operate at while delivering power to the transmission grid.
 * @param ratedNetMaxP The net rated maximum capacity determined by subtracting the auxiliary power used to operate the internal plant machinery from the rated gross maximum capacity.
 * @param shortPF Generating unit short term economic participation factor.
 * @param startupCost The initial startup cost incurred for each start of the GeneratingUnit.
 * @param startupTime Time it takes to get the unit on-line, from the time that the prime mover mechanical power is applied.
 * @param tieLinePF Generating unit economic participation factor.
 * @param totalEfficiency The efficiency of the unit in converting the fuel into electrical energy.
 * @param variableCost The variable cost component of production per unit of ActivePower.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] ControlArea specifications for this generating unit.
 * @param GenUnitOpCostCurves [[ch.ninecode.model.GenUnitOpCostCurve GenUnitOpCostCurve]] A generating unit may have one or more cost curves, depending upon fuel mixture and fuel cost.
 * @param GenUnitOpSchedule [[ch.ninecode.model.GenUnitOpSchedule GenUnitOpSchedule]] A generating unit may have an operating schedule, indicating the planned operation of the unit.
 * @param GrossToNetActivePowerCurves [[ch.ninecode.model.GrossToNetActivePowerCurve GrossToNetActivePowerCurve]] A generating unit may have a gross active power to net active power curve, describing the losses and auxiliary power requirements of the unit.
 * @param RotatingMachine [[ch.ninecode.model.RotatingMachine RotatingMachine]] A synchronous machine may operate as a generator and as such becomes a member of a generating unit.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class GeneratingUnit
(
    override val sup: Equipment = null,
    allocSpinResP: Double = 0.0,
    autoCntrlMarginP: Double = 0.0,
    baseP: Double = 0.0,
    controlDeadband: Double = 0.0,
    controlPulseHigh: Double = 0.0,
    controlPulseLow: Double = 0.0,
    controlResponseRate: Double = 0.0,
    efficiency: Double = 0.0,
    genControlMode: String = null,
    genControlSource: String = null,
    governorMPL: Double = 0.0,
    governorSCD: Double = 0.0,
    highControlLimit: Double = 0.0,
    initialP: Double = 0.0,
    longPF: Double = 0.0,
    lowControlLimit: Double = 0.0,
    lowerRampRate: Double = 0.0,
    maxEconomicP: Double = 0.0,
    maxOperatingP: Double = 0.0,
    maximumAllowableSpinningReserve: Double = 0.0,
    minEconomicP: Double = 0.0,
    minOperatingP: Double = 0.0,
    minimumOffTime: Double = 0.0,
    modelDetail: Int = 0,
    nominalP: Double = 0.0,
    normalPF: Double = 0.0,
    penaltyFactor: Double = 0.0,
    raiseRampRate: Double = 0.0,
    ratedGrossMaxP: Double = 0.0,
    ratedGrossMinP: Double = 0.0,
    ratedNetMaxP: Double = 0.0,
    shortPF: Double = 0.0,
    startupCost: Double = 0.0,
    startupTime: Double = 0.0,
    tieLinePF: Double = 0.0,
    totalEfficiency: Double = 0.0,
    variableCost: Double = 0.0,
    ControlAreaGeneratingUnit: List[String] = List(),
    GenUnitOpCostCurves: List[String] = List(),
    GenUnitOpSchedule: String = null,
    GrossToNetActivePowerCurves: List[String] = List(),
    RotatingMachine: List[String] = List()
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[GeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GeneratingUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GeneratingUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GeneratingUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GeneratingUnit.fields (position), x))
        emitelem (0, allocSpinResP)
        emitelem (1, autoCntrlMarginP)
        emitelem (2, baseP)
        emitelem (3, controlDeadband)
        emitelem (4, controlPulseHigh)
        emitelem (5, controlPulseLow)
        emitelem (6, controlResponseRate)
        emitelem (7, efficiency)
        emitattr (8, genControlMode)
        emitattr (9, genControlSource)
        emitelem (10, governorMPL)
        emitelem (11, governorSCD)
        emitelem (12, highControlLimit)
        emitelem (13, initialP)
        emitelem (14, longPF)
        emitelem (15, lowControlLimit)
        emitelem (16, lowerRampRate)
        emitelem (17, maxEconomicP)
        emitelem (18, maxOperatingP)
        emitelem (19, maximumAllowableSpinningReserve)
        emitelem (20, minEconomicP)
        emitelem (21, minOperatingP)
        emitelem (22, minimumOffTime)
        emitelem (23, modelDetail)
        emitelem (24, nominalP)
        emitelem (25, normalPF)
        emitelem (26, penaltyFactor)
        emitelem (27, raiseRampRate)
        emitelem (28, ratedGrossMaxP)
        emitelem (29, ratedGrossMinP)
        emitelem (30, ratedNetMaxP)
        emitelem (31, shortPF)
        emitelem (32, startupCost)
        emitelem (33, startupTime)
        emitelem (34, tieLinePF)
        emitelem (35, totalEfficiency)
        emitelem (36, variableCost)
        emitattrs (37, ControlAreaGeneratingUnit)
        emitattrs (38, GenUnitOpCostCurves)
        emitattr (39, GenUnitOpSchedule)
        emitattrs (40, GrossToNetActivePowerCurves)
        emitattrs (41, RotatingMachine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:GeneratingUnit>".format (id, export_fields)
    }
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "allocSpinResP",
        "autoCntrlMarginP",
        "baseP",
        "controlDeadband",
        "controlPulseHigh",
        "controlPulseLow",
        "controlResponseRate",
        "efficiency",
        "genControlMode",
        "genControlSource",
        "governorMPL",
        "governorSCD",
        "highControlLimit",
        "initialP",
        "longPF",
        "lowControlLimit",
        "lowerRampRate",
        "maxEconomicP",
        "maxOperatingP",
        "maximumAllowableSpinningReserve",
        "minEconomicP",
        "minOperatingP",
        "minimumOffTime",
        "modelDetail",
        "nominalP",
        "normalPF",
        "penaltyFactor",
        "raiseRampRate",
        "ratedGrossMaxP",
        "ratedGrossMinP",
        "ratedNetMaxP",
        "shortPF",
        "startupCost",
        "startupTime",
        "tieLinePF",
        "totalEfficiency",
        "variableCost",
        "ControlAreaGeneratingUnit",
        "GenUnitOpCostCurves",
        "GenUnitOpSchedule",
        "GrossToNetActivePowerCurves",
        "RotatingMachine"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", "0..*", "1"),
        Relationship ("GenUnitOpCostCurves", "GenUnitOpCostCurve", "0..*", "1"),
        Relationship ("GenUnitOpSchedule", "GenUnitOpSchedule", "0..1", "1"),
        Relationship ("GrossToNetActivePowerCurves", "GrossToNetActivePowerCurve", "0..*", "1"),
        Relationship ("RotatingMachine", "RotatingMachine", "0..*", "0..1")
    )
    val allocSpinResP: Fielder = parse_element (element (cls, fields(0)))
    val autoCntrlMarginP: Fielder = parse_element (element (cls, fields(1)))
    val baseP: Fielder = parse_element (element (cls, fields(2)))
    val controlDeadband: Fielder = parse_element (element (cls, fields(3)))
    val controlPulseHigh: Fielder = parse_element (element (cls, fields(4)))
    val controlPulseLow: Fielder = parse_element (element (cls, fields(5)))
    val controlResponseRate: Fielder = parse_element (element (cls, fields(6)))
    val efficiency: Fielder = parse_element (element (cls, fields(7)))
    val genControlMode: Fielder = parse_attribute (attribute (cls, fields(8)))
    val genControlSource: Fielder = parse_attribute (attribute (cls, fields(9)))
    val governorMPL: Fielder = parse_element (element (cls, fields(10)))
    val governorSCD: Fielder = parse_element (element (cls, fields(11)))
    val highControlLimit: Fielder = parse_element (element (cls, fields(12)))
    val initialP: Fielder = parse_element (element (cls, fields(13)))
    val longPF: Fielder = parse_element (element (cls, fields(14)))
    val lowControlLimit: Fielder = parse_element (element (cls, fields(15)))
    val lowerRampRate: Fielder = parse_element (element (cls, fields(16)))
    val maxEconomicP: Fielder = parse_element (element (cls, fields(17)))
    val maxOperatingP: Fielder = parse_element (element (cls, fields(18)))
    val maximumAllowableSpinningReserve: Fielder = parse_element (element (cls, fields(19)))
    val minEconomicP: Fielder = parse_element (element (cls, fields(20)))
    val minOperatingP: Fielder = parse_element (element (cls, fields(21)))
    val minimumOffTime: Fielder = parse_element (element (cls, fields(22)))
    val modelDetail: Fielder = parse_element (element (cls, fields(23)))
    val nominalP: Fielder = parse_element (element (cls, fields(24)))
    val normalPF: Fielder = parse_element (element (cls, fields(25)))
    val penaltyFactor: Fielder = parse_element (element (cls, fields(26)))
    val raiseRampRate: Fielder = parse_element (element (cls, fields(27)))
    val ratedGrossMaxP: Fielder = parse_element (element (cls, fields(28)))
    val ratedGrossMinP: Fielder = parse_element (element (cls, fields(29)))
    val ratedNetMaxP: Fielder = parse_element (element (cls, fields(30)))
    val shortPF: Fielder = parse_element (element (cls, fields(31)))
    val startupCost: Fielder = parse_element (element (cls, fields(32)))
    val startupTime: Fielder = parse_element (element (cls, fields(33)))
    val tieLinePF: Fielder = parse_element (element (cls, fields(34)))
    val totalEfficiency: Fielder = parse_element (element (cls, fields(35)))
    val variableCost: Fielder = parse_element (element (cls, fields(36)))
    val ControlAreaGeneratingUnit: FielderMultiple = parse_attributes (attribute (cls, fields(37)))
    val GenUnitOpCostCurves: FielderMultiple = parse_attributes (attribute (cls, fields(38)))
    val GenUnitOpSchedule: Fielder = parse_attribute (attribute (cls, fields(39)))
    val GrossToNetActivePowerCurves: FielderMultiple = parse_attributes (attribute (cls, fields(40)))
    val RotatingMachine: FielderMultiple = parse_attributes (attribute (cls, fields(41)))

    def parse (context: Context): GeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GeneratingUnit (
            Equipment.parse (context),
            toDouble (mask (allocSpinResP (), 0)),
            toDouble (mask (autoCntrlMarginP (), 1)),
            toDouble (mask (baseP (), 2)),
            toDouble (mask (controlDeadband (), 3)),
            toDouble (mask (controlPulseHigh (), 4)),
            toDouble (mask (controlPulseLow (), 5)),
            toDouble (mask (controlResponseRate (), 6)),
            toDouble (mask (efficiency (), 7)),
            mask (genControlMode (), 8),
            mask (genControlSource (), 9),
            toDouble (mask (governorMPL (), 10)),
            toDouble (mask (governorSCD (), 11)),
            toDouble (mask (highControlLimit (), 12)),
            toDouble (mask (initialP (), 13)),
            toDouble (mask (longPF (), 14)),
            toDouble (mask (lowControlLimit (), 15)),
            toDouble (mask (lowerRampRate (), 16)),
            toDouble (mask (maxEconomicP (), 17)),
            toDouble (mask (maxOperatingP (), 18)),
            toDouble (mask (maximumAllowableSpinningReserve (), 19)),
            toDouble (mask (minEconomicP (), 20)),
            toDouble (mask (minOperatingP (), 21)),
            toDouble (mask (minimumOffTime (), 22)),
            toInteger (mask (modelDetail (), 23)),
            toDouble (mask (nominalP (), 24)),
            toDouble (mask (normalPF (), 25)),
            toDouble (mask (penaltyFactor (), 26)),
            toDouble (mask (raiseRampRate (), 27)),
            toDouble (mask (ratedGrossMaxP (), 28)),
            toDouble (mask (ratedGrossMinP (), 29)),
            toDouble (mask (ratedNetMaxP (), 30)),
            toDouble (mask (shortPF (), 31)),
            toDouble (mask (startupCost (), 32)),
            toDouble (mask (startupTime (), 33)),
            toDouble (mask (tieLinePF (), 34)),
            toDouble (mask (totalEfficiency (), 35)),
            toDouble (mask (variableCost (), 36)),
            masks (ControlAreaGeneratingUnit (), 37),
            masks (GenUnitOpCostCurves (), 38),
            mask (GenUnitOpSchedule (), 39),
            masks (GrossToNetActivePowerCurves (), 40),
            masks (RotatingMachine (), 41)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between the generating unit's gross active power output on the X-axis (measured at the terminals of the machine(s)) and the generating unit's net active power output on the Y-axis (based on utility-defined measurements at the power station).
 *
 * Station service loads, when modelled, should be treated as non-conforming bus loads. There may be more than one curve, depending on the auxiliary equipment that is in service.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] A generating unit may have a gross active power to net active power curve, describing the losses and auxiliary power requirements of the unit.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class GrossToNetActivePowerCurve
(
    override val sup: Curve = null,
    GeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[GrossToNetActivePowerCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GrossToNetActivePowerCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GrossToNetActivePowerCurve.fields (position), value)
        emitattr (0, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GrossToNetActivePowerCurve rdf:ID=\"%s\">\n%s\t</cim:GrossToNetActivePowerCurve>".format (id, export_fields)
    }
}

object GrossToNetActivePowerCurve
extends
    Parseable[GrossToNetActivePowerCurve]
{
    override val fields: Array[String] = Array[String] (
        "GeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "GeneratingUnit", "1", "0..*")
    )
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): GrossToNetActivePowerCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GrossToNetActivePowerCurve (
            Curve.parse (context),
            mask (GeneratingUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit heat input in energy per time for main fuel (Y1-axis) and supplemental fuel (Y2-axis) versus unit output in active power (X-axis).
 *
 * The quantity of main fuel used to sustain generation at this output level is prorated for throttling between definition points. The quantity of supplemental fuel used at this output level is fixed and not prorated.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param auxPowerMult Power output - auxiliary power multiplier adjustment factor.
 * @param auxPowerOffset Power output - auxiliary power offset adjustment factor.
 * @param heatInputEff Heat input - efficiency multiplier adjustment factor.
 * @param heatInputOffset Heat input - offset adjustment factor.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have a heat input curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HeatInputCurve
(
    override val sup: Curve = null,
    auxPowerMult: Double = 0.0,
    auxPowerOffset: Double = 0.0,
    heatInputEff: Double = 0.0,
    heatInputOffset: Double = 0.0,
    isNetGrossP: Boolean = false,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HeatInputCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HeatInputCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HeatInputCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HeatInputCurve.fields (position), value)
        emitelem (0, auxPowerMult)
        emitelem (1, auxPowerOffset)
        emitelem (2, heatInputEff)
        emitelem (3, heatInputOffset)
        emitelem (4, isNetGrossP)
        emitattr (5, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HeatInputCurve rdf:ID=\"%s\">\n%s\t</cim:HeatInputCurve>".format (id, export_fields)
    }
}

object HeatInputCurve
extends
    Parseable[HeatInputCurve]
{
    override val fields: Array[String] = Array[String] (
        "auxPowerMult",
        "auxPowerOffset",
        "heatInputEff",
        "heatInputOffset",
        "isNetGrossP",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..1")
    )
    val auxPowerMult: Fielder = parse_element (element (cls, fields(0)))
    val auxPowerOffset: Fielder = parse_element (element (cls, fields(1)))
    val heatInputEff: Fielder = parse_element (element (cls, fields(2)))
    val heatInputOffset: Fielder = parse_element (element (cls, fields(3)))
    val isNetGrossP: Fielder = parse_element (element (cls, fields(4)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): HeatInputCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HeatInputCurve (
            Curve.parse (context),
            toDouble (mask (auxPowerMult (), 0)),
            toDouble (mask (auxPowerOffset (), 1)),
            toDouble (mask (heatInputEff (), 2)),
            toDouble (mask (heatInputOffset (), 3)),
            toBoolean (mask (isNetGrossP (), 4)),
            mask (ThermalGeneratingUnit (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit heat rate per active power (Y-axis) and  unit output (X-axis).
 *
 * The heat input is from all fuels.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have a heat rate curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HeatRateCurve
(
    override val sup: Curve = null,
    isNetGrossP: Boolean = false,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HeatRateCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HeatRateCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HeatRateCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HeatRateCurve.fields (position), value)
        emitelem (0, isNetGrossP)
        emitattr (1, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HeatRateCurve rdf:ID=\"%s\">\n%s\t</cim:HeatRateCurve>".format (id, export_fields)
    }
}

object HeatRateCurve
extends
    Parseable[HeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "isNetGrossP",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..1")
    )
    val isNetGrossP: Fielder = parse_element (element (cls, fields(0)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): HeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HeatRateCurve (
            Curve.parse (context),
            toBoolean (mask (isNetGrossP (), 0)),
            mask (ThermalGeneratingUnit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit efficiency as percentage and unit output active power for a given net head in meters.
 *
 * The relationship between efficiency, discharge, head, and power output is expressed as follows:   E =KP/HQ
 * where:  E is the efficiency, as a percentage; P is the active power; H is the height; Q is the discharge, volume/time unit; K is a constant.
 * For example, a curve instance for a given net head could show efficiency (Y-axis) versus active power output (X-axis) or versus discharge on the X-axis.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param HydroGeneratingUnit [[ch.ninecode.model.HydroGeneratingUnit HydroGeneratingUnit]] A hydro generating unit has an efficiency curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HydroGeneratingEfficiencyCurve
(
    override val sup: Curve = null,
    HydroGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HydroGeneratingEfficiencyCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroGeneratingEfficiencyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroGeneratingEfficiencyCurve.fields (position), value)
        emitattr (0, HydroGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroGeneratingEfficiencyCurve rdf:ID=\"%s\">\n%s\t</cim:HydroGeneratingEfficiencyCurve>".format (id, export_fields)
    }
}

object HydroGeneratingEfficiencyCurve
extends
    Parseable[HydroGeneratingEfficiencyCurve]
{
    override val fields: Array[String] = Array[String] (
        "HydroGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroGeneratingUnit", "HydroGeneratingUnit", "1", "0..*")
    )
    val HydroGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): HydroGeneratingEfficiencyCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroGeneratingEfficiencyCurve (
            Curve.parse (context),
            mask (HydroGeneratingUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generating unit whose prime mover is a hydraulic turbine (e.g., Francis, Pelton, Kaplan).
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param dropHeight The height water drops from the reservoir mid-point to the turbine.
 * @param energyConversionCapability Energy conversion capability for generating.
 * @param hydroUnitWaterCost The equivalent cost of water that drives the hydro turbine.
 * @param turbineType Type of turbine.
 * @param HydroGeneratingEfficiencyCurves [[ch.ninecode.model.HydroGeneratingEfficiencyCurve HydroGeneratingEfficiencyCurve]] A hydro generating unit has an efficiency curve.
 * @param HydroPowerPlant [[ch.ninecode.model.HydroPowerPlant HydroPowerPlant]] The hydro generating unit belongs to a hydro power plant.
 * @param PenstockLossCurve [[ch.ninecode.model.PenstockLossCurve PenstockLossCurve]] A hydro generating unit has a penstock loss curve.
 * @param TailbayLossCurve [[ch.ninecode.model.TailbayLossCurve TailbayLossCurve]] A hydro generating unit has a tailbay loss curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HydroGeneratingUnit
(
    override val sup: GeneratingUnit = null,
    dropHeight: Double = 0.0,
    energyConversionCapability: String = null,
    hydroUnitWaterCost: Double = 0.0,
    turbineType: String = null,
    HydroGeneratingEfficiencyCurves: List[String] = List(),
    HydroPowerPlant: String = null,
    PenstockLossCurve: String = null,
    TailbayLossCurve: List[String] = List()
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[HydroGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroGeneratingUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HydroGeneratingUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroGeneratingUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (HydroGeneratingUnit.fields (position), x))
        emitelem (0, dropHeight)
        emitattr (1, energyConversionCapability)
        emitelem (2, hydroUnitWaterCost)
        emitattr (3, turbineType)
        emitattrs (4, HydroGeneratingEfficiencyCurves)
        emitattr (5, HydroPowerPlant)
        emitattr (6, PenstockLossCurve)
        emitattrs (7, TailbayLossCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:HydroGeneratingUnit>".format (id, export_fields)
    }
}

object HydroGeneratingUnit
extends
    Parseable[HydroGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "dropHeight",
        "energyConversionCapability",
        "hydroUnitWaterCost",
        "turbineType",
        "HydroGeneratingEfficiencyCurves",
        "HydroPowerPlant",
        "PenstockLossCurve",
        "TailbayLossCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroGeneratingEfficiencyCurves", "HydroGeneratingEfficiencyCurve", "0..*", "1"),
        Relationship ("HydroPowerPlant", "HydroPowerPlant", "0..1", "0..*"),
        Relationship ("PenstockLossCurve", "PenstockLossCurve", "0..1", "1"),
        Relationship ("TailbayLossCurve", "TailbayLossCurve", "0..*", "1")
    )
    val dropHeight: Fielder = parse_element (element (cls, fields(0)))
    val energyConversionCapability: Fielder = parse_attribute (attribute (cls, fields(1)))
    val hydroUnitWaterCost: Fielder = parse_element (element (cls, fields(2)))
    val turbineType: Fielder = parse_attribute (attribute (cls, fields(3)))
    val HydroGeneratingEfficiencyCurves: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val HydroPowerPlant: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PenstockLossCurve: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TailbayLossCurve: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): HydroGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroGeneratingUnit (
            GeneratingUnit.parse (context),
            toDouble (mask (dropHeight (), 0)),
            mask (energyConversionCapability (), 1),
            toDouble (mask (hydroUnitWaterCost (), 2)),
            mask (turbineType (), 3),
            masks (HydroGeneratingEfficiencyCurves (), 4),
            mask (HydroPowerPlant (), 5),
            mask (PenstockLossCurve (), 6),
            masks (TailbayLossCurve (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A hydro power station which can generate or pump.
 *
 * When generating, the generator turbines receive water from an upper reservoir. When pumping, the pumps receive their water from a lower reservoir.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param dischargeTravelDelay Water travel delay from tailbay to next downstream hydro power station.
 * @param genRatedP The hydro plant's generating rating active power for rated head conditions.
 * @param hydroPlantStorageType The type of hydro power plant water storage.
 * @param penstockType Type and configuration of hydro plant penstock(s).
 * @param plantDischargeCapacity Total plant discharge capacity.
 * @param plantRatedHead The plant's rated gross head.
 * @param pumpRatedP The hydro plant's pumping rating active power for rated head conditions.
 * @param surgeTankCode A code describing the type (or absence) of surge tank that is associated with the hydro power plant.
 * @param surgeTankCrestLevel The level at which the surge tank spills.
 * @param GenSourcePumpDischargeReservoir [[ch.ninecode.model.Reservoir Reservoir]] Generators are supplied water from or pumps discharge water to an upstream reservoir.
 * @param HydroGeneratingUnits [[ch.ninecode.model.HydroGeneratingUnit HydroGeneratingUnit]] The hydro generating unit belongs to a hydro power plant.
 * @param HydroPumps [[ch.ninecode.model.HydroPump HydroPump]] The hydro pump may be a member of a pumped storage plant or a pump for distributing water.
 * @param Reservoir [[ch.ninecode.model.Reservoir Reservoir]] Generators discharge water to or pumps are supplied water from a downstream reservoir.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HydroPowerPlant
(
    override val sup: PowerSystemResource = null,
    dischargeTravelDelay: Double = 0.0,
    genRatedP: Double = 0.0,
    hydroPlantStorageType: String = null,
    penstockType: String = null,
    plantDischargeCapacity: Double = 0.0,
    plantRatedHead: Double = 0.0,
    pumpRatedP: Double = 0.0,
    surgeTankCode: String = null,
    surgeTankCrestLevel: Double = 0.0,
    GenSourcePumpDischargeReservoir: String = null,
    HydroGeneratingUnits: List[String] = List(),
    HydroPumps: List[String] = List(),
    Reservoir: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[HydroPowerPlant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroPowerPlant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HydroPowerPlant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroPowerPlant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (HydroPowerPlant.fields (position), x))
        emitelem (0, dischargeTravelDelay)
        emitelem (1, genRatedP)
        emitattr (2, hydroPlantStorageType)
        emitelem (3, penstockType)
        emitelem (4, plantDischargeCapacity)
        emitelem (5, plantRatedHead)
        emitelem (6, pumpRatedP)
        emitelem (7, surgeTankCode)
        emitelem (8, surgeTankCrestLevel)
        emitattr (9, GenSourcePumpDischargeReservoir)
        emitattrs (10, HydroGeneratingUnits)
        emitattrs (11, HydroPumps)
        emitattr (12, Reservoir)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroPowerPlant rdf:ID=\"%s\">\n%s\t</cim:HydroPowerPlant>".format (id, export_fields)
    }
}

object HydroPowerPlant
extends
    Parseable[HydroPowerPlant]
{
    override val fields: Array[String] = Array[String] (
        "dischargeTravelDelay",
        "genRatedP",
        "hydroPlantStorageType",
        "penstockType",
        "plantDischargeCapacity",
        "plantRatedHead",
        "pumpRatedP",
        "surgeTankCode",
        "surgeTankCrestLevel",
        "GenSourcePumpDischargeReservoir",
        "HydroGeneratingUnits",
        "HydroPumps",
        "Reservoir"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GenSourcePumpDischargeReservoir", "Reservoir", "1", "0..*"),
        Relationship ("HydroGeneratingUnits", "HydroGeneratingUnit", "0..*", "0..1"),
        Relationship ("HydroPumps", "HydroPump", "0..*", "0..1"),
        Relationship ("Reservoir", "Reservoir", "0..1", "0..*")
    )
    val dischargeTravelDelay: Fielder = parse_element (element (cls, fields(0)))
    val genRatedP: Fielder = parse_element (element (cls, fields(1)))
    val hydroPlantStorageType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val penstockType: Fielder = parse_element (element (cls, fields(3)))
    val plantDischargeCapacity: Fielder = parse_element (element (cls, fields(4)))
    val plantRatedHead: Fielder = parse_element (element (cls, fields(5)))
    val pumpRatedP: Fielder = parse_element (element (cls, fields(6)))
    val surgeTankCode: Fielder = parse_element (element (cls, fields(7)))
    val surgeTankCrestLevel: Fielder = parse_element (element (cls, fields(8)))
    val GenSourcePumpDischargeReservoir: Fielder = parse_attribute (attribute (cls, fields(9)))
    val HydroGeneratingUnits: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val HydroPumps: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val Reservoir: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): HydroPowerPlant =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroPowerPlant (
            PowerSystemResource.parse (context),
            toDouble (mask (dischargeTravelDelay (), 0)),
            toDouble (mask (genRatedP (), 1)),
            mask (hydroPlantStorageType (), 2),
            mask (penstockType (), 3),
            toDouble (mask (plantDischargeCapacity (), 4)),
            toDouble (mask (plantRatedHead (), 5)),
            toDouble (mask (pumpRatedP (), 6)),
            mask (surgeTankCode (), 7),
            toDouble (mask (surgeTankCrestLevel (), 8)),
            mask (GenSourcePumpDischargeReservoir (), 9),
            masks (HydroGeneratingUnits (), 10),
            masks (HydroPumps (), 11),
            mask (Reservoir (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A synchronous motor-driven pump, typically associated with a pumped storage plant.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param pumpDischAtMaxHead The pumping discharge under maximum head conditions, usually at full gate.
 * @param pumpDischAtMinHead The pumping discharge under minimum head conditions, usually at full gate.
 * @param pumpPowerAtMaxHead The pumping power under maximum head conditions, usually at full gate.
 * @param pumpPowerAtMinHead The pumping power under minimum head conditions, usually at full gate.
 * @param HydroPowerPlant [[ch.ninecode.model.HydroPowerPlant HydroPowerPlant]] The hydro pump may be a member of a pumped storage plant or a pump for distributing water.
 * @param HydroPumpOpSchedule [[ch.ninecode.model.HydroPumpOpSchedule HydroPumpOpSchedule]] The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
 * @param RotatingMachine [[ch.ninecode.model.RotatingMachine RotatingMachine]] The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation.
 *        The direction of machine rotation for pumping may or may not be the same as for generating.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HydroPump
(
    override val sup: Equipment = null,
    pumpDischAtMaxHead: Double = 0.0,
    pumpDischAtMinHead: Double = 0.0,
    pumpPowerAtMaxHead: Double = 0.0,
    pumpPowerAtMinHead: Double = 0.0,
    HydroPowerPlant: String = null,
    HydroPumpOpSchedule: String = null,
    RotatingMachine: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[HydroPump] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroPump.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HydroPump.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroPump.fields (position), value)
        emitelem (0, pumpDischAtMaxHead)
        emitelem (1, pumpDischAtMinHead)
        emitelem (2, pumpPowerAtMaxHead)
        emitelem (3, pumpPowerAtMinHead)
        emitattr (4, HydroPowerPlant)
        emitattr (5, HydroPumpOpSchedule)
        emitattr (6, RotatingMachine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroPump rdf:ID=\"%s\">\n%s\t</cim:HydroPump>".format (id, export_fields)
    }
}

object HydroPump
extends
    Parseable[HydroPump]
{
    override val fields: Array[String] = Array[String] (
        "pumpDischAtMaxHead",
        "pumpDischAtMinHead",
        "pumpPowerAtMaxHead",
        "pumpPowerAtMinHead",
        "HydroPowerPlant",
        "HydroPumpOpSchedule",
        "RotatingMachine"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroPowerPlant", "HydroPowerPlant", "0..1", "0..*"),
        Relationship ("HydroPumpOpSchedule", "HydroPumpOpSchedule", "0..1", "1"),
        Relationship ("RotatingMachine", "RotatingMachine", "1", "0..1")
    )
    val pumpDischAtMaxHead: Fielder = parse_element (element (cls, fields(0)))
    val pumpDischAtMinHead: Fielder = parse_element (element (cls, fields(1)))
    val pumpPowerAtMaxHead: Fielder = parse_element (element (cls, fields(2)))
    val pumpPowerAtMinHead: Fielder = parse_element (element (cls, fields(3)))
    val HydroPowerPlant: Fielder = parse_attribute (attribute (cls, fields(4)))
    val HydroPumpOpSchedule: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RotatingMachine: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): HydroPump =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroPump (
            Equipment.parse (context),
            toDouble (mask (pumpDischAtMaxHead (), 0)),
            toDouble (mask (pumpDischAtMinHead (), 1)),
            toDouble (mask (pumpPowerAtMaxHead (), 2)),
            toDouble (mask (pumpPowerAtMinHead (), 3)),
            mask (HydroPowerPlant (), 4),
            mask (HydroPumpOpSchedule (), 5),
            mask (RotatingMachine (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The hydro pump's Operator-approved current operating schedule (or plan), typically produced with the aid of unit commitment type analyses.
 *
 * The unit's operating schedule status is typically given as: (0=unavailable) (1=available to startup or shutdown)  (2=must pump).
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param HydroPump [[ch.ninecode.model.HydroPump HydroPump]] The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class HydroPumpOpSchedule
(
    override val sup: RegularIntervalSchedule = null,
    HydroPump: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[HydroPumpOpSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroPumpOpSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroPumpOpSchedule.fields (position), value)
        emitattr (0, HydroPump)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroPumpOpSchedule rdf:ID=\"%s\">\n%s\t</cim:HydroPumpOpSchedule>".format (id, export_fields)
    }
}

object HydroPumpOpSchedule
extends
    Parseable[HydroPumpOpSchedule]
{
    override val fields: Array[String] = Array[String] (
        "HydroPump"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroPump", "HydroPump", "1", "0..1")
    )
    val HydroPump: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): HydroPumpOpSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroPumpOpSchedule (
            RegularIntervalSchedule.parse (context),
            mask (HydroPump (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit incremental heat rate in (delta energy/time) per (delta active power) and unit output in active power.
 *
 * The IHR curve represents the slope of the HeatInputCurve. Note that the "incremental heat rate" and the "heat rate" have the same engineering units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have an incremental heat rate curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class IncrementalHeatRateCurve
(
    override val sup: Curve = null,
    isNetGrossP: Boolean = false,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[IncrementalHeatRateCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IncrementalHeatRateCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IncrementalHeatRateCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IncrementalHeatRateCurve.fields (position), value)
        emitelem (0, isNetGrossP)
        emitattr (1, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IncrementalHeatRateCurve rdf:ID=\"%s\">\n%s\t</cim:IncrementalHeatRateCurve>".format (id, export_fields)
    }
}

object IncrementalHeatRateCurve
extends
    Parseable[IncrementalHeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "isNetGrossP",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..1")
    )
    val isNetGrossP: Fielder = parse_element (element (cls, fields(0)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): IncrementalHeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IncrementalHeatRateCurve (
            Curve.parse (context),
            toBoolean (mask (isNetGrossP (), 0)),
            mask (ThermalGeneratingUnit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Natural water inflow to a reservoir, usually forecasted from predicted rain and snowmelt.
 *
 * Typically in one hour increments for up to 10 days. The forecast is given in average cubic meters per second over the time increment.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param Reservoir [[ch.ninecode.model.Reservoir Reservoir]] A reservoir may have a "natural" inflow forecast.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class InflowForecast
(
    override val sup: RegularIntervalSchedule = null,
    Reservoir: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[InflowForecast] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InflowForecast.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InflowForecast.fields (position), value)
        emitattr (0, Reservoir)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InflowForecast rdf:ID=\"%s\">\n%s\t</cim:InflowForecast>".format (id, export_fields)
    }
}

object InflowForecast
extends
    Parseable[InflowForecast]
{
    override val fields: Array[String] = Array[String] (
        "Reservoir"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Reservoir", "Reservoir", "1", "0..*")
    )
    val Reservoir: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): InflowForecast =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InflowForecast (
            RegularIntervalSchedule.parse (context),
            mask (Reservoir (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between reservoir volume and reservoir level.
 *
 * The  volume is at the Y-axis and the reservoir level at the X-axis.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param Reservoir [[ch.ninecode.model.Reservoir Reservoir]] A reservoir may have a level versus volume relationship.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class LevelVsVolumeCurve
(
    override val sup: Curve = null,
    Reservoir: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[LevelVsVolumeCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LevelVsVolumeCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LevelVsVolumeCurve.fields (position), value)
        emitattr (0, Reservoir)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LevelVsVolumeCurve rdf:ID=\"%s\">\n%s\t</cim:LevelVsVolumeCurve>".format (id, export_fields)
    }
}

object LevelVsVolumeCurve
extends
    Parseable[LevelVsVolumeCurve]
{
    override val fields: Array[String] = Array[String] (
        "Reservoir"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Reservoir", "Reservoir", "1", "0..*")
    )
    val Reservoir: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): LevelVsVolumeCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LevelVsVolumeCurve (
            Curve.parse (context),
            mask (Reservoir (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A nuclear generating unit.
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class NuclearGeneratingUnit
(
    override val sup: GeneratingUnit = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[NuclearGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:NuclearGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:NuclearGeneratingUnit>".format (id, export_fields)
    }
}

object NuclearGeneratingUnit
extends
    Parseable[NuclearGeneratingUnit]
{

    def parse (context: Context): NuclearGeneratingUnit =
    {
        implicit val ctx: Context = context
        val ret = NuclearGeneratingUnit (
            GeneratingUnit.parse (context)
        )
        ret
    }
}

/**
 * Relationship between penstock head loss (in meters) and  total discharge through the penstock (in cubic meters per second).
 *
 * One or more turbines may be connected to the same penstock.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param HydroGeneratingUnit [[ch.ninecode.model.HydroGeneratingUnit HydroGeneratingUnit]] A hydro generating unit has a penstock loss curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class PenstockLossCurve
(
    override val sup: Curve = null,
    HydroGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[PenstockLossCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PenstockLossCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PenstockLossCurve.fields (position), value)
        emitattr (0, HydroGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PenstockLossCurve rdf:ID=\"%s\">\n%s\t</cim:PenstockLossCurve>".format (id, export_fields)
    }
}

object PenstockLossCurve
extends
    Parseable[PenstockLossCurve]
{
    override val fields: Array[String] = Array[String] (
        "HydroGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroGeneratingUnit", "HydroGeneratingUnit", "1", "0..1")
    )
    val HydroGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PenstockLossCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PenstockLossCurve (
            Curve.parse (context),
            mask (HydroGeneratingUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A photovoltaic device or an aggregation of such devices.
 *
 * @param sup [[ch.ninecode.model.PowerElectronicsUnit PowerElectronicsUnit]] Reference to the superclass object.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class PhotoVoltaicUnit
(
    override val sup: PowerElectronicsUnit = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerElectronicsUnit: PowerElectronicsUnit = sup.asInstanceOf[PowerElectronicsUnit]
    override def copy (): Row = { clone ().asInstanceOf[PhotoVoltaicUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PhotoVoltaicUnit rdf:ID=\"%s\">\n%s\t</cim:PhotoVoltaicUnit>".format (id, export_fields)
    }
}

object PhotoVoltaicUnit
extends
    Parseable[PhotoVoltaicUnit]
{

    def parse (context: Context): PhotoVoltaicUnit =
    {
        implicit val ctx: Context = context
        val ret = PhotoVoltaicUnit (
            PowerElectronicsUnit.parse (context)
        )
        ret
    }
}

/**
 * A generating unit or battery or aggregation that connects to the AC network using power electronics rather than rotating machines.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param maxP Maximum active power limit.
 *        This is the maximum (nameplate) limit for the unit.
 * @param minP Minimum active power limit.
 *        This is the minimum (nameplate) limit for the unit.
 * @param PowerElectronicsConnection [[ch.ninecode.model.PowerElectronicsConnection PowerElectronicsConnection]] A power electronics unit has a connection to the AC network.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class PowerElectronicsUnit
(
    override val sup: Equipment = null,
    maxP: Double = 0.0,
    minP: Double = 0.0,
    PowerElectronicsConnection: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[PowerElectronicsUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerElectronicsUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerElectronicsUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerElectronicsUnit.fields (position), value)
        emitelem (0, maxP)
        emitelem (1, minP)
        emitattr (2, PowerElectronicsConnection)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerElectronicsUnit rdf:ID=\"%s\">\n%s\t</cim:PowerElectronicsUnit>".format (id, export_fields)
    }
}

object PowerElectronicsUnit
extends
    Parseable[PowerElectronicsUnit]
{
    override val fields: Array[String] = Array[String] (
        "maxP",
        "minP",
        "PowerElectronicsConnection"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PowerElectronicsConnection", "PowerElectronicsConnection", "1", "0..*")
    )
    val maxP: Fielder = parse_element (element (cls, fields(0)))
    val minP: Fielder = parse_element (element (cls, fields(1)))
    val PowerElectronicsConnection: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): PowerElectronicsUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerElectronicsUnit (
            Equipment.parse (context),
            toDouble (mask (maxP (), 0)),
            toDouble (mask (minP (), 1)),
            mask (PowerElectronicsConnection (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A wind generating unit that connects to the AC network with power electronics rather than rotating machines or an aggregation of such units.
 *
 * @param sup [[ch.ninecode.model.PowerElectronicsUnit PowerElectronicsUnit]] Reference to the superclass object.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class PowerElectronicsWindUnit
(
    override val sup: PowerElectronicsUnit = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerElectronicsUnit: PowerElectronicsUnit = sup.asInstanceOf[PowerElectronicsUnit]
    override def copy (): Row = { clone ().asInstanceOf[PowerElectronicsWindUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PowerElectronicsWindUnit rdf:ID=\"%s\">\n%s\t</cim:PowerElectronicsWindUnit>".format (id, export_fields)
    }
}

object PowerElectronicsWindUnit
extends
    Parseable[PowerElectronicsWindUnit]
{

    def parse (context: Context): PowerElectronicsWindUnit =
    {
        implicit val ctx: Context = context
        val ret = PowerElectronicsWindUnit (
            PowerElectronicsUnit.parse (context)
        )
        ret
    }
}

/**
 * A water storage facility within a hydro system, including: ponds, lakes, lagoons, and rivers.
 *
 * The storage is usually behind some type of dam.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param activeStorageCapacity Storage volume between the full supply level and the normal minimum operating level.
 * @param energyStorageRating The reservoir's energy storage rating in energy for given head conditions.
 * @param fullSupplyLevel Full supply level, above which water will spill.
 *        This can be the spillway crest level or the top of closed gates.
 * @param grossCapacity Total capacity of reservoir.
 * @param normalMinOperateLevel Normal minimum operating level below which the penstocks will draw air.
 * @param riverOutletWorks River outlet works for riparian right releases or other purposes.
 * @param spillTravelDelay The spillway water travel delay to the next downstream reservoir.
 * @param spillWayGateType Type of spillway gate, including parameters.
 * @param spillwayCapacity The flow capacity of the spillway in cubic meters per second.
 * @param spillwayCrestLength The length of the spillway crest.
 * @param spillwayCrestLevel Spillway crest level above which water will spill.
 * @param HydroPowerPlants [[ch.ninecode.model.HydroPowerPlant HydroPowerPlant]] Generators discharge water to or pumps are supplied water from a downstream reservoir.
 * @param InflowForecasts [[ch.ninecode.model.InflowForecast InflowForecast]] A reservoir may have a "natural" inflow forecast.
 * @param LevelVsVolumeCurves [[ch.ninecode.model.LevelVsVolumeCurve LevelVsVolumeCurve]] A reservoir may have a level versus volume relationship.
 * @param SpillsFromReservoir [[ch.ninecode.model.Reservoir Reservoir]] A reservoir may spill into a downstream reservoir.
 * @param SpillsIntoReservoirs [[ch.ninecode.model.Reservoir Reservoir]] A reservoir may spill into a downstream reservoir.
 * @param TargetLevelSchedule [[ch.ninecode.model.TargetLevelSchedule TargetLevelSchedule]] A reservoir may have a water level target schedule.
 * @param UpstreamFromHydroPowerPlants [[ch.ninecode.model.HydroPowerPlant HydroPowerPlant]] Generators are supplied water from or pumps discharge water to an upstream reservoir.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class Reservoir
(
    override val sup: PowerSystemResource = null,
    activeStorageCapacity: Double = 0.0,
    energyStorageRating: Double = 0.0,
    fullSupplyLevel: Double = 0.0,
    grossCapacity: Double = 0.0,
    normalMinOperateLevel: Double = 0.0,
    riverOutletWorks: String = null,
    spillTravelDelay: Double = 0.0,
    spillWayGateType: String = null,
    spillwayCapacity: Double = 0.0,
    spillwayCrestLength: Double = 0.0,
    spillwayCrestLevel: Double = 0.0,
    HydroPowerPlants: List[String] = List(),
    InflowForecasts: List[String] = List(),
    LevelVsVolumeCurves: List[String] = List(),
    SpillsFromReservoir: String = null,
    SpillsIntoReservoirs: List[String] = List(),
    TargetLevelSchedule: String = null,
    UpstreamFromHydroPowerPlants: List[String] = List()
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[Reservoir] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Reservoir.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Reservoir.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Reservoir.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Reservoir.fields (position), x))
        emitelem (0, activeStorageCapacity)
        emitelem (1, energyStorageRating)
        emitelem (2, fullSupplyLevel)
        emitelem (3, grossCapacity)
        emitelem (4, normalMinOperateLevel)
        emitelem (5, riverOutletWorks)
        emitelem (6, spillTravelDelay)
        emitelem (7, spillWayGateType)
        emitelem (8, spillwayCapacity)
        emitelem (9, spillwayCrestLength)
        emitelem (10, spillwayCrestLevel)
        emitattrs (11, HydroPowerPlants)
        emitattrs (12, InflowForecasts)
        emitattrs (13, LevelVsVolumeCurves)
        emitattr (14, SpillsFromReservoir)
        emitattrs (15, SpillsIntoReservoirs)
        emitattr (16, TargetLevelSchedule)
        emitattrs (17, UpstreamFromHydroPowerPlants)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Reservoir rdf:ID=\"%s\">\n%s\t</cim:Reservoir>".format (id, export_fields)
    }
}

object Reservoir
extends
    Parseable[Reservoir]
{
    override val fields: Array[String] = Array[String] (
        "activeStorageCapacity",
        "energyStorageRating",
        "fullSupplyLevel",
        "grossCapacity",
        "normalMinOperateLevel",
        "riverOutletWorks",
        "spillTravelDelay",
        "spillWayGateType",
        "spillwayCapacity",
        "spillwayCrestLength",
        "spillwayCrestLevel",
        "HydroPowerPlants",
        "InflowForecasts",
        "LevelVsVolumeCurves",
        "SpillsFromReservoir",
        "SpillsIntoReservoirs",
        "TargetLevelSchedule",
        "UpstreamFromHydroPowerPlants"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroPowerPlants", "HydroPowerPlant", "0..*", "0..1"),
        Relationship ("InflowForecasts", "InflowForecast", "0..*", "1"),
        Relationship ("LevelVsVolumeCurves", "LevelVsVolumeCurve", "0..*", "1"),
        Relationship ("SpillsFromReservoir", "Reservoir", "0..1", "0..*"),
        Relationship ("SpillsIntoReservoirs", "Reservoir", "0..*", "0..1"),
        Relationship ("TargetLevelSchedule", "TargetLevelSchedule", "0..1", "1"),
        Relationship ("UpstreamFromHydroPowerPlants", "HydroPowerPlant", "0..*", "1")
    )
    val activeStorageCapacity: Fielder = parse_element (element (cls, fields(0)))
    val energyStorageRating: Fielder = parse_element (element (cls, fields(1)))
    val fullSupplyLevel: Fielder = parse_element (element (cls, fields(2)))
    val grossCapacity: Fielder = parse_element (element (cls, fields(3)))
    val normalMinOperateLevel: Fielder = parse_element (element (cls, fields(4)))
    val riverOutletWorks: Fielder = parse_element (element (cls, fields(5)))
    val spillTravelDelay: Fielder = parse_element (element (cls, fields(6)))
    val spillWayGateType: Fielder = parse_element (element (cls, fields(7)))
    val spillwayCapacity: Fielder = parse_element (element (cls, fields(8)))
    val spillwayCrestLength: Fielder = parse_element (element (cls, fields(9)))
    val spillwayCrestLevel: Fielder = parse_element (element (cls, fields(10)))
    val HydroPowerPlants: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val InflowForecasts: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val LevelVsVolumeCurves: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val SpillsFromReservoir: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SpillsIntoReservoirs: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val TargetLevelSchedule: Fielder = parse_attribute (attribute (cls, fields(16)))
    val UpstreamFromHydroPowerPlants: FielderMultiple = parse_attributes (attribute (cls, fields(17)))

    def parse (context: Context): Reservoir =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Reservoir (
            PowerSystemResource.parse (context),
            toDouble (mask (activeStorageCapacity (), 0)),
            toDouble (mask (energyStorageRating (), 1)),
            toDouble (mask (fullSupplyLevel (), 2)),
            toDouble (mask (grossCapacity (), 3)),
            toDouble (mask (normalMinOperateLevel (), 4)),
            mask (riverOutletWorks (), 5),
            toDouble (mask (spillTravelDelay (), 6)),
            mask (spillWayGateType (), 7),
            toDouble (mask (spillwayCapacity (), 8)),
            toDouble (mask (spillwayCrestLength (), 9)),
            toDouble (mask (spillwayCrestLevel (), 10)),
            masks (HydroPowerPlants (), 11),
            masks (InflowForecasts (), 12),
            masks (LevelVsVolumeCurves (), 13),
            mask (SpillsFromReservoir (), 14),
            masks (SpillsIntoReservoirs (), 15),
            mask (TargetLevelSchedule (), 16),
            masks (UpstreamFromHydroPowerPlants (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between the rate in gross active power/minute (Y-axis) at which a unit should be shutdown and its present gross MW output (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param shutdownCost Fixed shutdown cost.
 * @param shutdownDate The date and time of the most recent generating unit shutdown.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have a shutdown curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class ShutdownCurve
(
    override val sup: Curve = null,
    shutdownCost: Double = 0.0,
    shutdownDate: String = null,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ShutdownCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ShutdownCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShutdownCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShutdownCurve.fields (position), value)
        emitelem (0, shutdownCost)
        emitelem (1, shutdownDate)
        emitattr (2, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShutdownCurve rdf:ID=\"%s\">\n%s\t</cim:ShutdownCurve>".format (id, export_fields)
    }
}

object ShutdownCurve
extends
    Parseable[ShutdownCurve]
{
    override val fields: Array[String] = Array[String] (
        "shutdownCost",
        "shutdownDate",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..1")
    )
    val shutdownCost: Fielder = parse_element (element (cls, fields(0)))
    val shutdownDate: Fielder = parse_element (element (cls, fields(1)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ShutdownCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShutdownCurve (
            Curve.parse (context),
            toDouble (mask (shutdownCost (), 0)),
            mask (shutdownDate (), 1),
            mask (ThermalGeneratingUnit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A solar thermal generating unit, connected to the grid by means of a rotating machine.
 *
 * This class does not represent photovoltaic (PV) generation.
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class SolarGeneratingUnit
(
    override val sup: GeneratingUnit = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[SolarGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SolarGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:SolarGeneratingUnit>".format (id, export_fields)
    }
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
{

    def parse (context: Context): SolarGeneratingUnit =
    {
        implicit val ctx: Context = context
        val ret = SolarGeneratingUnit (
            GeneratingUnit.parse (context)
        )
        ret
    }
}

/**
 * The quantity of ignition fuel (Y-axis) used to restart and repay the auxiliary power consumed versus the number of hours (X-axis) the unit was off line.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ignitionFuelType Type of ignition fuel.
 * @param StartupModel [[ch.ninecode.model.StartupModel StartupModel]] The unit's startup model may have a startup ignition fuel curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class StartIgnFuelCurve
(
    override val sup: Curve = null,
    ignitionFuelType: String = null,
    StartupModel: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartIgnFuelCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartIgnFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartIgnFuelCurve.fields (position), value)
        emitattr (0, ignitionFuelType)
        emitattr (1, StartupModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartIgnFuelCurve rdf:ID=\"%s\">\n%s\t</cim:StartIgnFuelCurve>".format (id, export_fields)
    }
}

object StartIgnFuelCurve
extends
    Parseable[StartIgnFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "ignitionFuelType",
        "StartupModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StartupModel", "StartupModel", "1", "0..1")
    )
    val ignitionFuelType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val StartupModel: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): StartIgnFuelCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartIgnFuelCurve (
            Curve.parse (context),
            mask (ignitionFuelType (), 0),
            mask (StartupModel (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The quantity of main fuel (Y-axis) used to restart and repay the auxiliary power consumed versus the number of hours (X-axis) the unit was off line.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param mainFuelType Type of main fuel.
 * @param StartupModel [[ch.ninecode.model.StartupModel StartupModel]] The unit's startup model may have a startup main fuel curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class StartMainFuelCurve
(
    override val sup: Curve = null,
    mainFuelType: String = null,
    StartupModel: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartMainFuelCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartMainFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartMainFuelCurve.fields (position), value)
        emitattr (0, mainFuelType)
        emitattr (1, StartupModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartMainFuelCurve rdf:ID=\"%s\">\n%s\t</cim:StartMainFuelCurve>".format (id, export_fields)
    }
}

object StartMainFuelCurve
extends
    Parseable[StartMainFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "mainFuelType",
        "StartupModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StartupModel", "StartupModel", "1", "0..1")
    )
    val mainFuelType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val StartupModel: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): StartMainFuelCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartMainFuelCurve (
            Curve.parse (context),
            mask (mainFuelType (), 0),
            mask (StartupModel (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Rate in gross active power per minute (Y-axis) at which a unit can be loaded versus the number of hours (X-axis) the unit was off line.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param hotStandbyRamp The startup ramp rate in gross for a unit that is on hot standby.
 * @param StartupModel [[ch.ninecode.model.StartupModel StartupModel]] The unit's startup model may have a startup ramp curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class StartRampCurve
(
    override val sup: Curve = null,
    hotStandbyRamp: Double = 0.0,
    StartupModel: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartRampCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartRampCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StartRampCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartRampCurve.fields (position), value)
        emitelem (0, hotStandbyRamp)
        emitattr (1, StartupModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartRampCurve rdf:ID=\"%s\">\n%s\t</cim:StartRampCurve>".format (id, export_fields)
    }
}

object StartRampCurve
extends
    Parseable[StartRampCurve]
{
    override val fields: Array[String] = Array[String] (
        "hotStandbyRamp",
        "StartupModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StartupModel", "StartupModel", "1", "0..1")
    )
    val hotStandbyRamp: Fielder = parse_element (element (cls, fields(0)))
    val StartupModel: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): StartRampCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartRampCurve (
            Curve.parse (context),
            toDouble (mask (hotStandbyRamp (), 0)),
            mask (StartupModel (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Unit start up characteristics depending on how long the unit has been off line.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fixedMaintCost Fixed maintenance cost.
 * @param hotStandbyHeat The amount of heat input per time unit required for hot standby operation.
 * @param incrementalMaintCost Incremental maintenance cost.
 * @param minimumDownTime The minimum number of hours the unit must be down before restart.
 * @param minimumRunTime The minimum number of hours the unit must be operating before being allowed to shut down.
 * @param riskFactorCost The opportunity cost associated with the return in monetary unit.
 *        This represents the restart's "share" of the unit depreciation and risk of an event which would damage the unit.
 * @param startupCost Total miscellaneous start up costs.
 * @param startupDate The date and time of the most recent generating unit startup.
 * @param startupPriority Startup priority within control area where lower numbers indicate higher priorities.
 *        More than one unit in an area may be assigned the same priority.
 * @param stbyAuxP The unit's auxiliary active power consumption to maintain standby mode.
 * @param StartIgnFuelCurve [[ch.ninecode.model.StartIgnFuelCurve StartIgnFuelCurve]] The unit's startup model may have a startup ignition fuel curve.
 * @param StartMainFuelCurve [[ch.ninecode.model.StartMainFuelCurve StartMainFuelCurve]] The unit's startup model may have a startup main fuel curve.
 * @param StartRampCurve [[ch.ninecode.model.StartRampCurve StartRampCurve]] The unit's startup model may have a startup ramp curve.
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] A thermal generating unit may have a startup model.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class StartupModel
(
    override val sup: IdentifiedObject = null,
    fixedMaintCost: Double = 0.0,
    hotStandbyHeat: Double = 0.0,
    incrementalMaintCost: Double = 0.0,
    minimumDownTime: Double = 0.0,
    minimumRunTime: Double = 0.0,
    riskFactorCost: Double = 0.0,
    startupCost: Double = 0.0,
    startupDate: String = null,
    startupPriority: Int = 0,
    stbyAuxP: Double = 0.0,
    StartIgnFuelCurve: String = null,
    StartMainFuelCurve: String = null,
    StartRampCurve: String = null,
    ThermalGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[StartupModel] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartupModel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StartupModel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartupModel.fields (position), value)
        emitelem (0, fixedMaintCost)
        emitelem (1, hotStandbyHeat)
        emitelem (2, incrementalMaintCost)
        emitelem (3, minimumDownTime)
        emitelem (4, minimumRunTime)
        emitelem (5, riskFactorCost)
        emitelem (6, startupCost)
        emitelem (7, startupDate)
        emitelem (8, startupPriority)
        emitelem (9, stbyAuxP)
        emitattr (10, StartIgnFuelCurve)
        emitattr (11, StartMainFuelCurve)
        emitattr (12, StartRampCurve)
        emitattr (13, ThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartupModel rdf:ID=\"%s\">\n%s\t</cim:StartupModel>".format (id, export_fields)
    }
}

object StartupModel
extends
    Parseable[StartupModel]
{
    override val fields: Array[String] = Array[String] (
        "fixedMaintCost",
        "hotStandbyHeat",
        "incrementalMaintCost",
        "minimumDownTime",
        "minimumRunTime",
        "riskFactorCost",
        "startupCost",
        "startupDate",
        "startupPriority",
        "stbyAuxP",
        "StartIgnFuelCurve",
        "StartMainFuelCurve",
        "StartRampCurve",
        "ThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StartIgnFuelCurve", "StartIgnFuelCurve", "0..1", "1"),
        Relationship ("StartMainFuelCurve", "StartMainFuelCurve", "0..1", "1"),
        Relationship ("StartRampCurve", "StartRampCurve", "0..1", "1"),
        Relationship ("ThermalGeneratingUnit", "ThermalGeneratingUnit", "1", "0..1")
    )
    val fixedMaintCost: Fielder = parse_element (element (cls, fields(0)))
    val hotStandbyHeat: Fielder = parse_element (element (cls, fields(1)))
    val incrementalMaintCost: Fielder = parse_element (element (cls, fields(2)))
    val minimumDownTime: Fielder = parse_element (element (cls, fields(3)))
    val minimumRunTime: Fielder = parse_element (element (cls, fields(4)))
    val riskFactorCost: Fielder = parse_element (element (cls, fields(5)))
    val startupCost: Fielder = parse_element (element (cls, fields(6)))
    val startupDate: Fielder = parse_element (element (cls, fields(7)))
    val startupPriority: Fielder = parse_element (element (cls, fields(8)))
    val stbyAuxP: Fielder = parse_element (element (cls, fields(9)))
    val StartIgnFuelCurve: Fielder = parse_attribute (attribute (cls, fields(10)))
    val StartMainFuelCurve: Fielder = parse_attribute (attribute (cls, fields(11)))
    val StartRampCurve: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: Context): StartupModel =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartupModel (
            IdentifiedObject.parse (context),
            toDouble (mask (fixedMaintCost (), 0)),
            toDouble (mask (hotStandbyHeat (), 1)),
            toDouble (mask (incrementalMaintCost (), 2)),
            toDouble (mask (minimumDownTime (), 3)),
            toDouble (mask (minimumRunTime (), 4)),
            toDouble (mask (riskFactorCost (), 5)),
            toDouble (mask (startupCost (), 6)),
            mask (startupDate (), 7),
            toInteger (mask (startupPriority (), 8)),
            toDouble (mask (stbyAuxP (), 9)),
            mask (StartIgnFuelCurve (), 10),
            mask (StartMainFuelCurve (), 11),
            mask (StartRampCurve (), 12),
            mask (ThermalGeneratingUnit (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The cogeneration plant's steam sendout schedule in volume per time unit.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param CogenerationPlant [[ch.ninecode.model.CogenerationPlant CogenerationPlant]] A cogeneration plant has a steam sendout schedule.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class SteamSendoutSchedule
(
    override val sup: RegularIntervalSchedule = null,
    CogenerationPlant: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[SteamSendoutSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SteamSendoutSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SteamSendoutSchedule.fields (position), value)
        emitattr (0, CogenerationPlant)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SteamSendoutSchedule rdf:ID=\"%s\">\n%s\t</cim:SteamSendoutSchedule>".format (id, export_fields)
    }
}

object SteamSendoutSchedule
extends
    Parseable[SteamSendoutSchedule]
{
    override val fields: Array[String] = Array[String] (
        "CogenerationPlant"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CogenerationPlant", "CogenerationPlant", "1", "1")
    )
    val CogenerationPlant: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SteamSendoutSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SteamSendoutSchedule (
            RegularIntervalSchedule.parse (context),
            mask (CogenerationPlant (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between tailbay head loss height (Y-axis) and the total discharge into the power station's tailbay volume per time unit (X-axis) .
 *
 * There could be more than one curve depending on the level of the tailbay reservoir or river level.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param HydroGeneratingUnit [[ch.ninecode.model.HydroGeneratingUnit HydroGeneratingUnit]] A hydro generating unit has a tailbay loss curve.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class TailbayLossCurve
(
    override val sup: Curve = null,
    HydroGeneratingUnit: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[TailbayLossCurve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TailbayLossCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TailbayLossCurve.fields (position), value)
        emitattr (0, HydroGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TailbayLossCurve rdf:ID=\"%s\">\n%s\t</cim:TailbayLossCurve>".format (id, export_fields)
    }
}

object TailbayLossCurve
extends
    Parseable[TailbayLossCurve]
{
    override val fields: Array[String] = Array[String] (
        "HydroGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HydroGeneratingUnit", "HydroGeneratingUnit", "1", "0..*")
    )
    val HydroGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TailbayLossCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TailbayLossCurve (
            Curve.parse (context),
            mask (HydroGeneratingUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Reservoir water level targets from advanced studies or "rule curves".
 *
 * Typically in one hour increments for up to 10 days.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param highLevelLimit High target level limit, above which the reservoir operation will be penalized.
 * @param lowLevelLimit Low target level limit, below which the reservoir operation will be penalized.
 * @param Reservoir [[ch.ninecode.model.Reservoir Reservoir]] A reservoir may have a water level target schedule.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class TargetLevelSchedule
(
    override val sup: Curve = null,
    highLevelLimit: Double = 0.0,
    lowLevelLimit: Double = 0.0,
    Reservoir: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[TargetLevelSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TargetLevelSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TargetLevelSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TargetLevelSchedule.fields (position), value)
        emitelem (0, highLevelLimit)
        emitelem (1, lowLevelLimit)
        emitattr (2, Reservoir)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TargetLevelSchedule rdf:ID=\"%s\">\n%s\t</cim:TargetLevelSchedule>".format (id, export_fields)
    }
}

object TargetLevelSchedule
extends
    Parseable[TargetLevelSchedule]
{
    override val fields: Array[String] = Array[String] (
        "highLevelLimit",
        "lowLevelLimit",
        "Reservoir"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Reservoir", "Reservoir", "1", "0..1")
    )
    val highLevelLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowLevelLimit: Fielder = parse_element (element (cls, fields(1)))
    val Reservoir: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TargetLevelSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TargetLevelSchedule (
            Curve.parse (context),
            toDouble (mask (highLevelLimit (), 0)),
            toDouble (mask (lowLevelLimit (), 1)),
            mask (Reservoir (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generating unit whose prime mover could be a steam turbine, combustion turbine, or diesel engine.
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param oMCost Operating and maintenance cost for the thermal unit.
 * @param CAESPlant [[ch.ninecode.model.CAESPlant CAESPlant]] A thermal generating unit may be a member of a compressed air energy storage plant.
 * @param CogenerationPlant [[ch.ninecode.model.CogenerationPlant CogenerationPlant]] A thermal generating unit may be a member of a cogeneration plant.
 * @param CombinedCyclePlant [[ch.ninecode.model.CombinedCyclePlant CombinedCyclePlant]] A thermal generating unit may be a member of a combined cycle plant.
 * @param EmissionCurves [[ch.ninecode.model.EmissionCurve EmissionCurve]] A thermal generating unit may have  one or more emission curves.
 * @param EmmissionAccounts [[ch.ninecode.model.EmissionAccount EmissionAccount]] A thermal generating unit may have one or more emission allowance accounts.
 * @param FossilFuels [[ch.ninecode.model.FossilFuel FossilFuel]] A thermal generating unit may have one or more fossil fuels.
 * @param FuelAllocationSchedules [[ch.ninecode.model.FuelAllocationSchedule FuelAllocationSchedule]] A thermal generating unit may have one or more fuel allocation schedules.
 * @param HeatInputCurve [[ch.ninecode.model.HeatInputCurve HeatInputCurve]] A thermal generating unit may have a heat input curve.
 * @param HeatRateCurve [[ch.ninecode.model.HeatRateCurve HeatRateCurve]] A thermal generating unit may have a heat rate curve.
 * @param IncrementalHeatRateCurve [[ch.ninecode.model.IncrementalHeatRateCurve IncrementalHeatRateCurve]] A thermal generating unit may have an incremental heat rate curve.
 * @param ShutdownCurve [[ch.ninecode.model.ShutdownCurve ShutdownCurve]] A thermal generating unit may have a shutdown curve.
 * @param StartupModel [[ch.ninecode.model.StartupModel StartupModel]] A thermal generating unit may have a startup model.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class ThermalGeneratingUnit
(
    override val sup: GeneratingUnit = null,
    oMCost: Double = 0.0,
    CAESPlant: String = null,
    CogenerationPlant: String = null,
    CombinedCyclePlant: String = null,
    EmissionCurves: List[String] = List(),
    EmmissionAccounts: List[String] = List(),
    FossilFuels: List[String] = List(),
    FuelAllocationSchedules: List[String] = List(),
    HeatInputCurve: String = null,
    HeatRateCurve: String = null,
    IncrementalHeatRateCurve: String = null,
    ShutdownCurve: String = null,
    StartupModel: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[ThermalGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ThermalGeneratingUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ThermalGeneratingUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ThermalGeneratingUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ThermalGeneratingUnit.fields (position), x))
        emitelem (0, oMCost)
        emitattr (1, CAESPlant)
        emitattr (2, CogenerationPlant)
        emitattr (3, CombinedCyclePlant)
        emitattrs (4, EmissionCurves)
        emitattrs (5, EmmissionAccounts)
        emitattrs (6, FossilFuels)
        emitattrs (7, FuelAllocationSchedules)
        emitattr (8, HeatInputCurve)
        emitattr (9, HeatRateCurve)
        emitattr (10, IncrementalHeatRateCurve)
        emitattr (11, ShutdownCurve)
        emitattr (12, StartupModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ThermalGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:ThermalGeneratingUnit>".format (id, export_fields)
    }
}

object ThermalGeneratingUnit
extends
    Parseable[ThermalGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "oMCost",
        "CAESPlant",
        "CogenerationPlant",
        "CombinedCyclePlant",
        "EmissionCurves",
        "EmmissionAccounts",
        "FossilFuels",
        "FuelAllocationSchedules",
        "HeatInputCurve",
        "HeatRateCurve",
        "IncrementalHeatRateCurve",
        "ShutdownCurve",
        "StartupModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CAESPlant", "CAESPlant", "0..1", "0..1"),
        Relationship ("CogenerationPlant", "CogenerationPlant", "0..1", "0..*"),
        Relationship ("CombinedCyclePlant", "CombinedCyclePlant", "0..1", "0..*"),
        Relationship ("EmissionCurves", "EmissionCurve", "0..*", "1"),
        Relationship ("EmmissionAccounts", "EmissionAccount", "0..*", "1"),
        Relationship ("FossilFuels", "FossilFuel", "0..*", "1"),
        Relationship ("FuelAllocationSchedules", "FuelAllocationSchedule", "0..*", "1"),
        Relationship ("HeatInputCurve", "HeatInputCurve", "0..1", "1"),
        Relationship ("HeatRateCurve", "HeatRateCurve", "0..1", "1"),
        Relationship ("IncrementalHeatRateCurve", "IncrementalHeatRateCurve", "0..1", "1"),
        Relationship ("ShutdownCurve", "ShutdownCurve", "0..1", "1"),
        Relationship ("StartupModel", "StartupModel", "0..1", "1")
    )
    val oMCost: Fielder = parse_element (element (cls, fields(0)))
    val CAESPlant: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CogenerationPlant: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CombinedCyclePlant: Fielder = parse_attribute (attribute (cls, fields(3)))
    val EmissionCurves: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val EmmissionAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val FossilFuels: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val FuelAllocationSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val HeatInputCurve: Fielder = parse_attribute (attribute (cls, fields(8)))
    val HeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(9)))
    val IncrementalHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ShutdownCurve: Fielder = parse_attribute (attribute (cls, fields(11)))
    val StartupModel: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): ThermalGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ThermalGeneratingUnit (
            GeneratingUnit.parse (context),
            toDouble (mask (oMCost (), 0)),
            mask (CAESPlant (), 1),
            mask (CogenerationPlant (), 2),
            mask (CombinedCyclePlant (), 3),
            masks (EmissionCurves (), 4),
            masks (EmmissionAccounts (), 5),
            masks (FossilFuels (), 6),
            masks (FuelAllocationSchedules (), 7),
            mask (HeatInputCurve (), 8),
            mask (HeatRateCurve (), 9),
            mask (IncrementalHeatRateCurve (), 10),
            mask (ShutdownCurve (), 11),
            mask (StartupModel (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A wind driven generating unit, connected to the grid by means of a rotating machine.
 *
 * May be used to represent a single turbine or an aggregation.
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param windGenUnitType The kind of wind generating unit.
 * @group Production
 * @groupname Production Package Production
 * @groupdesc Production The production package is responsible for classes which describe various kinds of generators. These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */
final case class WindGeneratingUnit
(
    override val sup: GeneratingUnit = null,
    windGenUnitType: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[WindGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindGeneratingUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGeneratingUnit.fields (position), value)
        emitattr (0, windGenUnitType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:WindGeneratingUnit>".format (id, export_fields)
    }
}

object WindGeneratingUnit
extends
    Parseable[WindGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "windGenUnitType"
    )
    val windGenUnitType: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WindGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGeneratingUnit (
            GeneratingUnit.parse (context),
            mask (windGenUnitType (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Production
{
    def register: List[ClassInfo] =
    {
        List (
            AirCompressor.register,
            BatteryUnit.register,
            CAESPlant.register,
            CogenerationPlant.register,
            CombinedCyclePlant.register,
            EmissionAccount.register,
            EmissionCurve.register,
            FossilFuel.register,
            FuelAllocationSchedule.register,
            GenUnitOpCostCurve.register,
            GenUnitOpSchedule.register,
            GeneratingUnit.register,
            GrossToNetActivePowerCurve.register,
            HeatInputCurve.register,
            HeatRateCurve.register,
            HydroGeneratingEfficiencyCurve.register,
            HydroGeneratingUnit.register,
            HydroPowerPlant.register,
            HydroPump.register,
            HydroPumpOpSchedule.register,
            IncrementalHeatRateCurve.register,
            InflowForecast.register,
            LevelVsVolumeCurve.register,
            NuclearGeneratingUnit.register,
            PenstockLossCurve.register,
            PhotoVoltaicUnit.register,
            PowerElectronicsUnit.register,
            PowerElectronicsWindUnit.register,
            Reservoir.register,
            ShutdownCurve.register,
            SolarGeneratingUnit.register,
            StartIgnFuelCurve.register,
            StartMainFuelCurve.register,
            StartRampCurve.register,
            StartupModel.register,
            SteamSendoutSchedule.register,
            TailbayLossCurve.register,
            TargetLevelSchedule.register,
            ThermalGeneratingUnit.register,
            WindGeneratingUnit.register
        )
    }
}