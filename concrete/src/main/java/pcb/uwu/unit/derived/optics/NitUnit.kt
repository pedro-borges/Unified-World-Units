package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit

object NitUnit
    : LuminanceUnit(luminousIntensityUnit = CandelaUnit,
                    areaUnit = SquareMeterUnit)
{
    override val symbol = "nit"
    override val singularName = "nit"
    override val pluralName = "nits"
}