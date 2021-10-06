package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object WattUnit
    : PowerUnit(lengthUnit = MeterUnit,
                massUnit = KiloGramUnit,
                timeUnit = SecondUnit)
{
    override val symbol = "W"
    override val singularName = "watt"
    override val pluralName = "watts"
}
