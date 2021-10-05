package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.scalar.SteradianUnit

object LumenUnit
    : LuminousFluxUnit(luminousIntensityUnit = CandelaUnit,
                       solidAngleUnit = SteradianUnit)
{
    override val symbol = "lm"
    override val singularName = "lumen"
    override val pluralName = "lumens"
}