package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class CurrentRelay
(
    override val sup: Element,
    val currentLimit1: Double,
    val currentLimit2: Double,
    val currentLimit3: Double,
    val inverseTimeFlag: Boolean,
    val timeDelay1: Double,
    val timeDelay2: Double,
    val timeDelay3: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[CurrentRelay]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentRelay
extends
    Parser
{
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))_
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))_
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))_
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))_
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))_
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))_
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay2"""))_
    def parse (context: Context): CurrentRelay =
    {
        return (
            CurrentRelay
            (
                ProtectionEquipment.parse (context),
                toDouble (currentLimit1 (context), context),
                toDouble (currentLimit2 (context), context),
                toDouble (currentLimit3 (context), context),
                toBoolean (inverseTimeFlag (context), context),
                toDouble (timeDelay1 (context), context),
                toDouble (timeDelay2 (context), context),
                toDouble (timeDelay3 (context), context)
            )
        )
    }
}

case class ProtectionEquipment
(
    override val sup: Element,
    val highLimit: Double,
    val lowLimit: Double,
    val powerDirectionFlag: Boolean,
    val relayDelayTime: Double,
    val unitMultiplier: String,
    val unitSymbol: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ProtectionEquipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipment
extends
    Parser
{
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))_
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))_
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))_
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))_
    val unitMultiplier = parse_element (element ("""ProtectionEquipment.unitMultiplier"""))_
    val unitSymbol = parse_element (element ("""ProtectionEquipment.unitSymbol"""))_
    def parse (context: Context): ProtectionEquipment =
    {
        return (
            ProtectionEquipment
            (
                Equipment.parse (context),
                toDouble (highLimit (context), context),
                toDouble (lowLimit (context), context),
                toBoolean (powerDirectionFlag (context), context),
                toDouble (relayDelayTime (context), context),
                unitMultiplier (context),
                unitSymbol (context)
            )
        )
    }
}
