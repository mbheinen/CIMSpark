package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.
 * It is linked to a specific generator (synchronous machine).
 */

/**
 * This class provides the resistive and reactive components of compensation for the generator associated with the IEEE Type 2 voltage compensator for current flow out of one of the other generators in the interconnection.
 * @param sup Reference to the superclass object.
 * @param rcij <font color="#0f0f0f">Resistive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Rcij).</font>
 * @param xcij <font color="#0f0f0f">Reactive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Xcij).</font>
 * @param SynchronousMachineDynamics Standard synchronous machine out of which current flow is being compensated for.
 * @param VcompIEEEType2 The standard IEEE Type 2 voltage compensator of this compensation.
 */
case class GenICompensationForGenJ
(
    override val sup: IdentifiedObject,
    rcij: Double,
    xcij: Double,
    SynchronousMachineDynamics: String,
    VcompIEEEType2: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[GenICompensationForGenJ] }
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
        "\t\t<cim:GenICompensationForGenJ.rcij>" + rcij + "</cim:GenICompensationForGenJ.rcij>\n" +
        "\t\t<cim:GenICompensationForGenJ.xcij>" + xcij + "</cim:GenICompensationForGenJ.xcij>\n" +
        (if (null != SynchronousMachineDynamics) "\t\t<cim:GenICompensationForGenJ.SynchronousMachineDynamics rdf:resource=\"#" + SynchronousMachineDynamics + "\"/>\n" else "") +
        (if (null != VcompIEEEType2) "\t\t<cim:GenICompensationForGenJ.VcompIEEEType2 rdf:resource=\"#" + VcompIEEEType2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenICompensationForGenJ rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenICompensationForGenJ>\n"
    }
}

object GenICompensationForGenJ
extends
    Parseable[GenICompensationForGenJ]
{
    val rcij: (Context) => String = parse_element (element ("""GenICompensationForGenJ.rcij"""))
    val xcij: (Context) => String = parse_element (element ("""GenICompensationForGenJ.xcij"""))
    val SynchronousMachineDynamics: (Context) => String = parse_attribute (attribute ("""GenICompensationForGenJ.SynchronousMachineDynamics"""))
    val VcompIEEEType2: (Context) => String = parse_attribute (attribute ("""GenICompensationForGenJ.VcompIEEEType2"""))
    def parse (context: Context): GenICompensationForGenJ =
    {
        GenICompensationForGenJ(
            IdentifiedObject.parse (context),
            toDouble (rcij (context), context),
            toDouble (xcij (context), context),
            SynchronousMachineDynamics (context),
            VcompIEEEType2 (context)
        )
    }
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 * This model is common to all excitation system models described in the IEEE Standard. </font>
 * @param sup Reference to the superclass object.
 * @param rc <font color="#0f0f0f">Resistive component of compensation of a generator (Rc).</font>
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @param xc <font color="#0f0f0f">Reactive component of compensation of a generator (Xc).</font>
 */
case class VCompIEEEType1
(
    override val sup: VoltageCompensatorDynamics,
    rc: Double,
    tr: Double,
    xc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VCompIEEEType1] }
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
        "\t\t<cim:VCompIEEEType1.rc>" + rc + "</cim:VCompIEEEType1.rc>\n" +
        "\t\t<cim:VCompIEEEType1.tr>" + tr + "</cim:VCompIEEEType1.tr>\n" +
        "\t\t<cim:VCompIEEEType1.xc>" + xc + "</cim:VCompIEEEType1.xc>\n"
    }
    override def export: String =
    {
        "\t<cim:VCompIEEEType1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VCompIEEEType1>\n"
    }
}

object VCompIEEEType1
extends
    Parseable[VCompIEEEType1]
{
    val rc: (Context) => String = parse_element (element ("""VCompIEEEType1.rc"""))
    val tr: (Context) => String = parse_element (element ("""VCompIEEEType1.tr"""))
    val xc: (Context) => String = parse_element (element ("""VCompIEEEType1.xc"""))
    def parse (context: Context): VCompIEEEType1 =
    {
        VCompIEEEType1(
            VoltageCompensatorDynamics.parse (context),
            toDouble (rc (context), context),
            toDouble (tr (context), context),
            toDouble (xc (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 * This model is designed to cover the following types of compensation: </font>
 * @param sup Reference to the superclass object.
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 */
case class VCompIEEEType2
(
    override val sup: VoltageCompensatorDynamics,
    tr: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VCompIEEEType2] }
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
        "\t\t<cim:VCompIEEEType2.tr>" + tr + "</cim:VCompIEEEType2.tr>\n"
    }
    override def export: String =
    {
        "\t<cim:VCompIEEEType2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VCompIEEEType2>\n"
    }
}

object VCompIEEEType2
extends
    Parseable[VCompIEEEType2]
{
    val tr: (Context) => String = parse_element (element ("""VCompIEEEType2.tr"""))
    def parse (context: Context): VCompIEEEType2 =
    {
        VCompIEEEType2(
            VoltageCompensatorDynamics.parse (context),
            toDouble (tr (context), context)
        )
    }
}

/**
 * Voltage compensator function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this voltage compensator is associated.
 * @param RemoteInputSignal Remote input signal used by this voltage compensator model.
 */
case class VoltageCompensatorDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String,
    RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[VoltageCompensatorDynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:VoltageCompensatorDynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:VoltageCompensatorDynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VoltageCompensatorDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageCompensatorDynamics>\n"
    }
}

object VoltageCompensatorDynamics
extends
    Parseable[VoltageCompensatorDynamics]
{
    val ExcitationSystemDynamics: (Context) => String = parse_attribute (attribute ("""VoltageCompensatorDynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal: (Context) => String = parse_attribute (attribute ("""VoltageCompensatorDynamics.RemoteInputSignal"""))
    def parse (context: Context): VoltageCompensatorDynamics =
    {
        VoltageCompensatorDynamics(
            DynamicsFunctionBlock.parse (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

private[ninecode] object _VoltageCompensatorDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            GenICompensationForGenJ.register,
            VCompIEEEType1.register,
            VCompIEEEType2.register,
            VoltageCompensatorDynamics.register
        )
    }
}