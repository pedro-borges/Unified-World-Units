package pcb.uwu.unit.scalar

import pcb.uwu.unit.base.RadianUnit

object SteradianUnit
    : SolidAngleUnit(angleUnit1 = RadianUnit,
                     angleUnit2 = RadianUnit)
{
    override val symbol = "sr"
    override val singularName = "steradian"
    override val pluralName = "steradians"
}