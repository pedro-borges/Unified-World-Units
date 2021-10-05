package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object HenryUnit
    : ElectricInductanceUnit(massUnit = KiloGramUnit,
                             lengthUnit = MeterUnit,
                             electricCurrentUnit = AmpereUnit,
                             timeUnit = SecondUnit)
{
    override val symbol = "H"
    override val singularName = "henry"
    override val pluralName = "henrys"
}