package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.scalar.SteradianUnit

object LumenUnit
    : LuminousFluxUnit(CandelaUnit, SteradianUnit)
{
    override val symbol = "lm"
    override val singularName = "lumen"
    override val pluralName = "lumens"
}