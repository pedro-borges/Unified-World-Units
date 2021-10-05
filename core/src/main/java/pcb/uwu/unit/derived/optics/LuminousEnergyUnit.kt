package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.scalar.SolidAngleUnit

open class LuminousEnergyUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                solidAngleUnit: SolidAngleUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit.unitCounter)
                        .major(solidAngleUnit)
                        .major(timeUnit))
}