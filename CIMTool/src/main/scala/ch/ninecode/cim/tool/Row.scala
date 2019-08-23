package ch.ninecode.cim.tool

import java.util.Map

case class Row (fields: Map[String,Object])
{
    def this (raw: Object) = this (raw.asInstanceOf[Map[String,Object]])

    def getInt (name: String): Int =
    {
        val raw = fields.get (name)
        if ((null != raw) && raw.isInstanceOf[Int])
            raw.asInstanceOf[Int]
        else
            0
    }

    def getString (name: String): String =
    {
        val raw = fields.get (name)
        if (null != raw)
            raw.toString
        else
            ""
    }

    def getTrimmedString (name: String): String =
    {
        val text = getString (name)
        if (null != text)
        {
            val trimmed = text.trim
            if (0 != trimmed.length)
                trimmed
            else
                null
        }
        else
            null
    }

    def isNull (name: String): Boolean = null != fields.get (name)

    def getObjectID: Int              = getInt ("Object_ID")
    def getPackageID: Int             = getInt ("Package_ID")
    def getParentID: Int              = getInt ("Parent_ID")
    def getStartObjectID: Int         = getInt ("Start_Object_ID")
    def getEndObjectID: Int           = getInt ("End_Object_ID")
    def getClassifier: Int            = getInt ("Classifier")
    def hasClassifier: Boolean        = 0 != getClassifier
    def getXUID: String               = { val xuid = getString ("ea_guid"); s"_${xuid.substring (1, xuid.length - 1)}" }
    def getName: String               = getString ("Name")
    def getObjectType: String         = getString ("Object_Type")
    def getConnectorType: String      = getString ("Connector_Type")
    def getNote: String               = getTrimmedString ("Note")
    def getNotes: String              = getTrimmedString ("Notes")
    def getStereotype: String         = getString ("Stereotype")
    def hasStereotype: Boolean        = isNull ("Stereotype")
    def hasDefault: Boolean           = isNull ("Default")
    def getDefault: String            = getString ("Default")
    def getDestRole: String           = getString ("DestRole")
    def getDestRoleNote: String       = getString ("DestRoleNote")
    def getDestCard: String           = getString ("DestCard")
    def getDestIsAggregate: Boolean   = 0 != getInt ("DestIsAggregate")
    def getSourceRole: String         = getString ("SourceRole")
    def getSourceRoleNote: String     = getString ("SourceRoleNote")
    def getSourceCard: String         = getString ("SourceCard")
    def getSourceIsAggregate: Boolean = 0 != getInt ("SourceIsAggregate")
    def getType: String               = getString ("Type")
}