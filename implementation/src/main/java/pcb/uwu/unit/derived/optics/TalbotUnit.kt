package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.SecondUnit

object TalbotUnit
    : LuminousEnergyUnit(luminousFluxUnit = LumenUnit,
                         timeUnit = SecondUnit)
{
    override val symbol = "T"
    override val singularName = "talbot"
    override val pluralName = "talbots"
}