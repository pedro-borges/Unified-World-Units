package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.SecondUnit

object CoulombUnit
    : ElectricChargeUnit(electricCurrentUnit = AmpereUnit,
                         timeUnit = SecondUnit)
{
    override val symbol = "C"
    override val singularName = "coulomb"
    override val pluralName = "coulombs"
}
