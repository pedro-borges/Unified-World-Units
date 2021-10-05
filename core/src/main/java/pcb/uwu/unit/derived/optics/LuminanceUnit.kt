package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.LuminousIntensityUnit

open class LuminanceUnit
    : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit.unitCounter)
                        .minor(lengthUnit, 2))
}