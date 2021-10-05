package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object OhmUnit
    : ElectricResistanceUnit(massUnit = KiloGramUnit,
                             lengthUnit = MeterUnit,
                             electricCurrentUnit = AmpereUnit,
                             timeUnit = SecondUnit)
{
    override val symbol = "Ω"
    override val singularName = "ohm"
    override val pluralName = "ohms"
}