package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object FaradUnit
    : ElectricCapacitanceUnit(electricCurrentUnit = AmpereUnit,
                              timeUnit = SecondUnit,
                              lengthUnit = MeterUnit,
                              massUnit = KiloGramUnit)
{
    override val symbol = "F"
    override val singularName = "farad"
    override val pluralName = "farads"
}
