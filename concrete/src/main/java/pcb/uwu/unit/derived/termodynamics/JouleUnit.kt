package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object JouleUnit
    : EnergyUnit(lengthUnit = MeterUnit,
                 massUnit = KiloGramUnit,
                 timeUnit = SecondUnit)
{
    override val symbol = "J"
    override val singularName = "joule"
    override val pluralName = "joules"
}