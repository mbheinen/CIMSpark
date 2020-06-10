package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCAinverter
(
    Element: BasicElement = null
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
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CCAinverter rdf:ID=\"%s\">\n%s\t</cim:CCAinverter>".format (id, export_fields)
    }
}

object CCAinverter
extends
    CIMParseable[CCAinverter]
{

    def parse (context: CIMContext): CCAinverter =
    {
        val ret = CCAinverter (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCArectifierControl
(
    Element: BasicElement = null
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
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CCArectifierControl rdf:ID=\"%s\">\n%s\t</cim:CCArectifierControl>".format (id, export_fields)
    }
}

object CCArectifierControl
extends
    CIMParseable[CCArectifierControl]
{

    def parse (context: CIMContext): CCArectifierControl =
    {
        val ret = CCArectifierControl (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CSCtype1
(
    CSCDynamics: CSCDynamics = null
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
    override def sup: CSCDynamics = CSCDynamics

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CSCtype1 rdf:ID=\"%s\">\n%s\t</cim:CSCtype1>".format (id, export_fields)
    }
}

object CSCtype1
extends
    CIMParseable[CSCtype1]
{

    def parse (context: CIMContext): CSCtype1 =
    {
        val ret = CSCtype1 (
            CSCDynamics.parse (context)
        )
        ret
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IdcInverterControl
(
    Element: BasicElement = null
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
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:IdcInverterControl rdf:ID=\"%s\">\n%s\t</cim:IdcInverterControl>".format (id, export_fields)
    }
}

object IdcInverterControl
extends
    CIMParseable[IdcInverterControl]
{

    def parse (context: CIMContext): IdcInverterControl =
    {
        val ret = IdcInverterControl (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IgnAngleContInverter
(
    Element: BasicElement = null
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
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:IgnAngleContInverter rdf:ID=\"%s\">\n%s\t</cim:IgnAngleContInverter>".format (id, export_fields)
    }
}

object IgnAngleContInverter
extends
    CIMParseable[IgnAngleContInverter]
{

    def parse (context: CIMContext): IgnAngleContInverter =
    {
        val ret = IgnAngleContInverter (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class VDCOL
(
    Element: BasicElement = null
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
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:VDCOL rdf:ID=\"%s\">\n%s\t</cim:VDCOL>".format (id, export_fields)
    }
}

object VDCOL
extends
    CIMParseable[VDCOL]
{

    def parse (context: CIMContext): VDCOL =
    {
        val ret = VDCOL (
            BasicElement.parse (context)
        )
        ret
    }
}

private[ninecode] object _CSC
{
    def register: List[CIMClassInfo] =
    {
        List (
            CCAinverter.register,
            CCArectifierControl.register,
            CSCtype1.register,
            IdcInverterControl.register,
            IgnAngleContInverter.register,
            VDCOL.register
        )
    }
}