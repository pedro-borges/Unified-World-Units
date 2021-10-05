package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.scalar.SolidAngleUnit

open class LuminousFluxUnit
    : CompositeUnit
{
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                solidAngleUnit: SolidAngleUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit)
                        .major(solidAngleUnit))

    constructor(illuminanceUnit: IlluminanceUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(illuminanceUnit)
                        .major(areaUnit))

    constructor(luminousEnergyUnit: LuminousEnergyUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(luminousEnergyUnit)
                        .minor(timeUnit))
}