package pcb.uwu.unit.derived.optics

import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.derived.geometry.SteradianUnit

object LuxUnit
    : IlluminanceUnit(luminousIntensityUnit = CandelaUnit,
                      solidAngleUnit = SteradianUnit,
                      lengthUnit = MeterUnit)
{
    override val symbol = "lx"
    override val singularName = "lux"
    override val pluralName = "lux"
}
