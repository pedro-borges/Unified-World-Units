package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit

open class LuminanceUnit
    : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit)
                        .minor(areaUnit))
}