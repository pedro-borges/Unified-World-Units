package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.SecondUnit

object TeslaUnit
    : MagneticFieldUnit(massUnit = KiloGramUnit,
                        electricCurrentUnit = AmpereUnit,
                        timeUnit = SecondUnit)
{
    override val symbol = "T"
    override val singularName = "tesla"
    override val pluralName = "teslas"
}