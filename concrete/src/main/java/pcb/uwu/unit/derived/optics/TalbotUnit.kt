package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.SecondUnit

object TalbotUnit
    : LuminousEnergyUnit(LumenUnit, SecondUnit)
{
    override val symbol = "T"
    override val singularName = "talbot"
    override val pluralName = "talbots"
}