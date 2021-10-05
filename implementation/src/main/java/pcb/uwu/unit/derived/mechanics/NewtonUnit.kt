package pcb.uwu.unit.derived.mechanics

import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object NewtonUnit
    : ForceUnit(massUnit = KiloGramUnit,
                lengthUnit = MeterUnit,
                timeUnit = SecondUnit)
{
    override val symbol = "N"
    override val singularName = "newton"
    override val pluralName = "newtons"
}