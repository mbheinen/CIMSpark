package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Asynchronous machine whose behaviour is described by reference to a standard model expressed in either time constant reactance form or equivalent circuit form <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * 
 * <b>Parameter Notes:</b>
 * <ol>
 * <li>Asynchronous machine parameters such as <b>Xl, Xs</b> etc. are actually used as inductances (L) in the model, but are commonly referred to as reactances since, at nominal frequency, the per unit values are the same.
 *
 * However, some references use the symbol L instead of X. </li>
 *
 * @param sup [[ch.ninecode.model.RotatingMachineDynamics RotatingMachineDynamics]] Reference to the superclass object.
 * @param AsynchronousMachine [[ch.ninecode.model.AsynchronousMachine AsynchronousMachine]] Asynchronous machine to which this asynchronous machine dynamics model applies.
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Mechanical load model associated with this asynchronous machine model.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor model associated with this asynchronous machine model.
 * @param WindTurbineType1or2Dynamics [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Wind generator type 1 or 2 model associated with this asynchronous machine model.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
    AsynchronousMachine: String,
    MechanicalLoadDynamics: String,
    TurbineGovernorDynamics: String,
    WindTurbineType1or2Dynamics: String
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
    def RotatingMachineDynamics: RotatingMachineDynamics = sup.asInstanceOf[RotatingMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineDynamics] }
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
        implicit val clz: String = AsynchronousMachineDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AsynchronousMachineDynamics.fields (position), value)
        emitattr (0, AsynchronousMachine)
        emitattr (1, MechanicalLoadDynamics)
        emitattr (2, TurbineGovernorDynamics)
        emitattr (3, WindTurbineType1or2Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineDynamics rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineDynamics>".format (id, export_fields)
    }
}

object AsynchronousMachineDynamics
extends
    Parseable[AsynchronousMachineDynamics]
{
    override val fields: Array[String] = Array[String] (
        "AsynchronousMachine",
        "MechanicalLoadDynamics",
        "TurbineGovernorDynamics",
        "WindTurbineType1or2Dynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AsynchronousMachine", "AsynchronousMachine", "1", "0..1"),
        Relationship ("MechanicalLoadDynamics", "MechanicalLoadDynamics", "0..1", "0..1"),
        Relationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "0..1", "0..1"),
        Relationship ("WindTurbineType1or2Dynamics", "WindTurbineType1or2Dynamics", "0..1", "1")
    )
    val AsynchronousMachine: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MechanicalLoadDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WindTurbineType1or2Dynamics: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): AsynchronousMachineDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineDynamics (
            RotatingMachineDynamics.parse (context),
            mask (AsynchronousMachine (), 0),
            mask (MechanicalLoadDynamics (), 1),
            mask (TurbineGovernorDynamics (), 2),
            mask (WindTurbineType1or2Dynamics (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The electrical equations of all variations of the asynchronous model are based on the AsynchronousEquivalentCircuit diagram for the direct and quadrature axes, with two equivalent rotor windings in each axis.
 * 
 * <b>Equations for conversion between Equivalent Circuit and Time Constant Reactance forms:</b>
 * <b>Xs</b> = <b>Xm</b> + <b>Xl</b>
 * <b>X'</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b> / (<b>Xm</b> + <b>Xlr1</b>)
 * <b>X''</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b>* <b>Xlr2</b> / (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>)
 * <b>T'o</b> = (<b>Xm</b> + <b>Xlr1</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr1</b>)
 * <b>T''o</b> = (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr2</b> * (<b>Xm </b>+ <b>Xlr1</b>)
 * <b>
 * </b>Same equations using CIM attributes from AsynchronousMachineTimeConstantReactance class on left of = sign and AsynchronousMachineEquivalentCircuit class on right (except as noted):
 * xs = xm + RotatingMachineDynamics.statorLeakageReactance
 * xp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1 / (xm + xlr1)
 * xpp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1* xlr2 / (xm * xlr1 + xm * xlr2 + xlr1 * xlr2)
 * tpo = (xm + xlr1) / (2*pi*nominal frequency * rr1)
 *
 * tppo = (xm * xlr1 + xm * xlr2 + xlr1 * xlr2) / (2*pi*nominal frequency * rr2 * (xm + xlr1).
 *
 * @param sup [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineEquivalentCircuit
(
    override val sup: AsynchronousMachineDynamics,
    rr1: Double,
    rr2: Double,
    xlr1: Double,
    xlr2: Double,
    xm: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineEquivalentCircuit] }
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
        implicit val clz: String = AsynchronousMachineEquivalentCircuit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineEquivalentCircuit.fields (position), value)
        emitelem (0, rr1)
        emitelem (1, rr2)
        emitelem (2, xlr1)
        emitelem (3, xlr2)
        emitelem (4, xm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineEquivalentCircuit rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineEquivalentCircuit>".format (id, export_fields)
    }
}

object AsynchronousMachineEquivalentCircuit
extends
    Parseable[AsynchronousMachineEquivalentCircuit]
{
    override val fields: Array[String] = Array[String] (
        "rr1",
        "rr2",
        "xlr1",
        "xlr2",
        "xm"
    )
    val rr1: Fielder = parse_element (element (cls, fields(0)))
    val rr2: Fielder = parse_element (element (cls, fields(1)))
    val xlr1: Fielder = parse_element (element (cls, fields(2)))
    val xlr2: Fielder = parse_element (element (cls, fields(3)))
    val xm: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): AsynchronousMachineEquivalentCircuit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineEquivalentCircuit (
            AsynchronousMachineDynamics.parse (context),
            toDouble (mask (rr1 (), 0)),
            toDouble (mask (rr2 (), 1)),
            toDouble (mask (xlr1 (), 2)),
            toDouble (mask (xlr2 (), 3)),
            toDouble (mask (xm (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * <b>Parameter Notes:</b>
 * <ol>
 * <li>If <b>X''</b> = <b>X'</b>, a single cage (one equivalent rotor winding per axis) is modelled.</li>
 * <li>The �p� in the attribute names is a substitution for a �prime� in the usual parameter notation, e.g. tpo refers to T'o.</li>
 * </ol>
 * 
 * The parameters used for models expressed in time constant reactance form include:
 * <ul>
 * <li>RotatingMachine.ratedS (MVAbase)</li>
 * <li>RotatingMachineDynamics.damping (D)</li>
 * <li>RotatingMachineDynamics.inertia (H)</li>
 * <li>RotatingMachineDynamics.saturationFactor (S1)</li>
 * <li>RotatingMachineDynamics.saturationFactor120 (S12)</li>
 * <li>RotatingMachineDynamics.statorLeakageReactance (Xl)</li>
 * <li>RotatingMachineDynamics.statorResistance (Rs)</li>
 * <li>.xs (Xs)</li>
 * <li>.xp (X')</li>
 * <li>.xpp (X'')</li>
 * <li>.tpo (T'o)</li>
 * <li>.tppo (T''o).</li>
 *
 * </ul>
 *
 * @param sup [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param tpo Transient rotor time constant (T'o) (&gt; T''o).
 *        Typical Value = 5.
 * @param tppo Subtransient rotor time constant (T''o) (&gt; 0).
 *        Typical Value = 0.03.
 * @param xp Transient reactance (unsaturated) (X') (&gt;=X'').
 *        Typical Value = 0.5.
 * @param xpp Subtransient reactance (unsaturated) (X'') (&gt; Xl).
 *        Typical Value = 0.2.
 * @param xs Synchronous reactance (Xs) (&gt;= X').
 *        Typical Value = 1.8.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineTimeConstantReactance
(
    override val sup: AsynchronousMachineDynamics,
    tpo: Double,
    tppo: Double,
    xp: Double,
    xpp: Double,
    xs: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineTimeConstantReactance] }
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
        implicit val clz: String = AsynchronousMachineTimeConstantReactance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineTimeConstantReactance.fields (position), value)
        emitelem (0, tpo)
        emitelem (1, tppo)
        emitelem (2, xp)
        emitelem (3, xpp)
        emitelem (4, xs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineTimeConstantReactance rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineTimeConstantReactance>".format (id, export_fields)
    }
}

object AsynchronousMachineTimeConstantReactance
extends
    Parseable[AsynchronousMachineTimeConstantReactance]
{
    override val fields: Array[String] = Array[String] (
        "tpo",
        "tppo",
        "xp",
        "xpp",
        "xs"
    )
    val tpo: Fielder = parse_element (element (cls, fields(0)))
    val tppo: Fielder = parse_element (element (cls, fields(1)))
    val xp: Fielder = parse_element (element (cls, fields(2)))
    val xpp: Fielder = parse_element (element (cls, fields(3)))
    val xs: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): AsynchronousMachineTimeConstantReactance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineTimeConstantReactance (
            AsynchronousMachineDynamics.parse (context),
            toDouble (mask (tpo (), 0)),
            toDouble (mask (tppo (), 1)),
            toDouble (mask (xp (), 2)),
            toDouble (mask (xpp (), 3)),
            toDouble (mask (xs (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _AsynchronousMachineDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            AsynchronousMachineDynamics.register,
            AsynchronousMachineEquivalentCircuit.register,
            AsynchronousMachineTimeConstantReactance.register
        )
    }
}