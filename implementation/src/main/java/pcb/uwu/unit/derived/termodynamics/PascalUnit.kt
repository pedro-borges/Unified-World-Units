package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object PascalUnit
    : PressureUnit(lengthUnit = MeterUnit,
                   massUnit = KiloGramUnit,
                   timeUnit = SecondUnit)
{
    override val symbol = "Pa"
    override val singularName = "pascal"
    override val pluralName = "pascals"
}
