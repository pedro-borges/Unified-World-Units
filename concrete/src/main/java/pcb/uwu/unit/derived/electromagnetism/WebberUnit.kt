package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object WebberUnit
    : MagneticFluxUnit(massUnit = KiloGramUnit,
                       lengthUnit = MeterUnit,
                       electricCurrentUnit = AmpereUnit,
                       timeUnit = SecondUnit)
{
    override val symbol = "Wb"
    override val singularName = "webber"
    override val pluralName = "webbers"
}