package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.
 * These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */

/**
 * AuxiliaryEquipment describe equipment that is not performing any primary functions but support for the equipment performing the primary function.
 * AuxiliaryEquipment is attached to primary eqipment via an association with Terminal.
 * @param sup Reference to the superclass object.
 * @param Terminal The Terminal at the equipment where the AuxiliaryEquipment is attached.
 */
case class AuxiliaryEquipment
(
    override val sup: Equipment,
    Terminal: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryEquipment] }
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
        sup.export_fields +
        (if (null != Terminal) "\t\t<cim:AuxiliaryEquipment.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryEquipment>\n"
    }
}

object AuxiliaryEquipment
extends
    Parseable[AuxiliaryEquipment]
{
    val Terminal: (Context) => String = parse_attribute (attribute ("""AuxiliaryEquipment.Terminal"""))
    def parse (context: Context): AuxiliaryEquipment =
    {
        AuxiliaryEquipment(
            Equipment.parse (context),
            Terminal (context)
        )
    }
}

/**
 * Instrument transformer used to measure electrical qualities of the circuit that is being protected and/or monitored.
 * Typically used as current transducer for the purpose of metering or protection. A typical secondary current rating would be 5A.
 * @param sup Reference to the superclass object.
 * @param accuracyClass CT accuracy classification.
 * @param accuracyLimit Percent of rated current for which the CT remains accurate within specified limits.
 * @param coreBurden Power burden of the CT core.
 * @param ctClass CT classification; i.e. class 10P.
 * @param usage Intended usage of the CT; i.e. metering, protection.
 */
case class CurrentTransformer
(
    override val sup: Sensor,
    accuracyClass: String,
    accuracyLimit: Double,
    coreBurden: Double,
    ctClass: String,
    usage: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[CurrentTransformer] }
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
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:CurrentTransformer.accuracyClass>" + accuracyClass + "</cim:CurrentTransformer.accuracyClass>\n" else "") +
        "\t\t<cim:CurrentTransformer.accuracyLimit>" + accuracyLimit + "</cim:CurrentTransformer.accuracyLimit>\n" +
        "\t\t<cim:CurrentTransformer.coreBurden>" + coreBurden + "</cim:CurrentTransformer.coreBurden>\n" +
        (if (null != ctClass) "\t\t<cim:CurrentTransformer.ctClass>" + ctClass + "</cim:CurrentTransformer.ctClass>\n" else "") +
        (if (null != usage) "\t\t<cim:CurrentTransformer.usage>" + usage + "</cim:CurrentTransformer.usage>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentTransformer>\n"
    }
}

object CurrentTransformer
extends
    Parseable[CurrentTransformer]
{
    val accuracyClass: (Context) => String = parse_element (element ("""CurrentTransformer.accuracyClass"""))
    val accuracyLimit: (Context) => String = parse_element (element ("""CurrentTransformer.accuracyLimit"""))
    val coreBurden: (Context) => String = parse_element (element ("""CurrentTransformer.coreBurden"""))
    val ctClass: (Context) => String = parse_element (element ("""CurrentTransformer.ctClass"""))
    val usage: (Context) => String = parse_element (element ("""CurrentTransformer.usage"""))
    def parse (context: Context): CurrentTransformer =
    {
        CurrentTransformer(
            Sensor.parse (context),
            accuracyClass (context),
            toDouble (accuracyLimit (context), context),
            toDouble (coreBurden (context), context),
            ctClass (context),
            usage (context)
        )
    }
}

/**
 * A FaultIndicator is typically only an indicator (which may or may not be remotely monitored), and not a piece of equipment that actually initiates a protection event.
 * It is used for FLISR (Fault Location, Isolation and Restoration) purposes, assisting with the dispatch of crews to "most likely" part of the network (i.e. assists with determining circuit section where the fault most likely happened).
 * @param sup Reference to the superclass object.
 */
case class FaultIndicator
(
    override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[FaultIndicator] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:FaultIndicator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultIndicator>\n"
    }
}

object FaultIndicator
extends
    Parseable[FaultIndicator]
{
    def parse (context: Context): FaultIndicator =
    {
        FaultIndicator(
            AuxiliaryEquipment.parse (context)
        )
    }
}

/**
 * A sensor used mainly in overhead distribution networks as the source of both current and voltage measurements.
 * @param sup Reference to the superclass object.
 */
case class PostLineSensor
(
    override val sup: Sensor
)
extends
    Element
{
    def this () = { this (null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[PostLineSensor] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PostLineSensor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PostLineSensor>\n"
    }
}

object PostLineSensor
extends
    Parseable[PostLineSensor]
{
    def parse (context: Context): PostLineSensor =
    {
        PostLineSensor(
            Sensor.parse (context)
        )
    }
}

/**
 * Instrument transformer (also known as Voltage Transformer) used to measure electrical qualities of the circuit that is being protected and/or monitored.
 * Typically used as voltage transducer for the purpose of metering, protection, or sometimes auxiliary substation supply. A typical secondary voltage rating would be 120V.
 * @param sup Reference to the superclass object.
 * @param accuracyClass PT accuracy classification.
 * @param nominalRatio Nominal ratio between the primary and secondary voltage.
 * @param ptClass Potential transformer (PT) classification covering burden.
 * @param typ Potential transformer construction type.
 */
case class PotentialTransformer
(
    override val sup: Sensor,
    accuracyClass: String,
    nominalRatio: Double,
    ptClass: String,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[PotentialTransformer] }
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
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:PotentialTransformer.accuracyClass>" + accuracyClass + "</cim:PotentialTransformer.accuracyClass>\n" else "") +
        "\t\t<cim:PotentialTransformer.nominalRatio>" + nominalRatio + "</cim:PotentialTransformer.nominalRatio>\n" +
        (if (null != ptClass) "\t\t<cim:PotentialTransformer.ptClass>" + ptClass + "</cim:PotentialTransformer.ptClass>\n" else "") +
        (if (null != typ) "\t\t<cim:PotentialTransformer.type rdf:resource=\"#" + typ + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PotentialTransformer>\n"
    }
}

object PotentialTransformer
extends
    Parseable[PotentialTransformer]
{
    val accuracyClass: (Context) => String = parse_element (element ("""PotentialTransformer.accuracyClass"""))
    val nominalRatio: (Context) => String = parse_element (element ("""PotentialTransformer.nominalRatio"""))
    val ptClass: (Context) => String = parse_element (element ("""PotentialTransformer.ptClass"""))
    val typ: (Context) => String = parse_attribute (attribute ("""PotentialTransformer.type"""))
    def parse (context: Context): PotentialTransformer =
    {
        PotentialTransformer(
            Sensor.parse (context),
            accuracyClass (context),
            toDouble (nominalRatio (context), context),
            ptClass (context),
            typ (context)
        )
    }
}

/**
 * The construction kind of the potential transformer.
 * @param sup Reference to the superclass object.
 * @param capacitiveCoupling The potential transformer is using capacitive coupling to create secondary voltage.
 * @param inductive The potential transformer is using induction coils to create secondary voltage.
 */
case class PotentialTransformerKind
(
    override val sup: BasicElement,
    capacitiveCoupling: String,
    inductive: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PotentialTransformerKind] }
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
        sup.export_fields +
        (if (null != capacitiveCoupling) "\t\t<cim:PotentialTransformerKind.capacitiveCoupling rdf:resource=\"#" + capacitiveCoupling + "\"/>\n" else "") +
        (if (null != inductive) "\t\t<cim:PotentialTransformerKind.inductive rdf:resource=\"#" + inductive + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformerKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PotentialTransformerKind>\n"
    }
}

object PotentialTransformerKind
extends
    Parseable[PotentialTransformerKind]
{
    val capacitiveCoupling: (Context) => String = parse_attribute (attribute ("""PotentialTransformerKind.capacitiveCoupling"""))
    val inductive: (Context) => String = parse_attribute (attribute ("""PotentialTransformerKind.inductive"""))
    def parse (context: Context): PotentialTransformerKind =
    {
        PotentialTransformerKind(
            BasicElement.parse (context),
            capacitiveCoupling (context),
            inductive (context)
        )
    }
}

/**
 * This class describe devices that transform a measured quantity into signals that can be presented at displays, used in control or be recorded.
 * @param sup Reference to the superclass object.
 */
case class Sensor
(
    override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Sensor] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Sensor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Sensor>\n"
    }
}

object Sensor
extends
    Parseable[Sensor]
{
    def parse (context: Context): Sensor =
    {
        Sensor(
            AuxiliaryEquipment.parse (context)
        )
    }
}

/**
 * Shunt device, installed on the network, usually in the proximity of electrical equipment in order to protect the said equipment against transient voltage transients caused by lightning or switching activity.
 * @param sup Reference to the superclass object.
 */
case class SurgeArrester
(
    override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[SurgeArrester] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:SurgeArrester rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SurgeArrester>\n"
    }
}

object SurgeArrester
extends
    Parseable[SurgeArrester]
{
    def parse (context: Context): SurgeArrester =
    {
        SurgeArrester(
            AuxiliaryEquipment.parse (context)
        )
    }
}

/**
 * Line traps are devices that impede high frequency power line carrier signals yet present a negligible impedance at the main power frequency.
 * @param sup Reference to the superclass object.
 */
case class WaveTrap
(
    override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[WaveTrap] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:WaveTrap rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WaveTrap>\n"
    }
}

object WaveTrap
extends
    Parseable[WaveTrap]
{
    def parse (context: Context): WaveTrap =
    {
        WaveTrap(
            AuxiliaryEquipment.parse (context)
        )
    }
}

private[ninecode] object _AuxiliaryEquipment
{
    def register: List[ClassInfo] =
    {
        List (
            AuxiliaryEquipment.register,
            CurrentTransformer.register,
            FaultIndicator.register,
            PostLineSensor.register,
            PotentialTransformer.register,
            PotentialTransformerKind.register,
            Sensor.register,
            SurgeArrester.register,
            WaveTrap.register
        )
    }
}