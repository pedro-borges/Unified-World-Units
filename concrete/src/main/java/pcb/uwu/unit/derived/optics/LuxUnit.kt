package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.scalar.SteradianUnit

object LuxUnit
    : IlluminanceUnit(CandelaUnit, SteradianUnit, MeterUnit)
{
    override val symbol = "lx"
    override val singularName = "lux"
    override val pluralName = "lux"
}