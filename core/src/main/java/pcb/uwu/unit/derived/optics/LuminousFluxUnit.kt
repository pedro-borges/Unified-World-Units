package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.scalar.SolidAngleUnit

open class LuminousFluxUnit
    : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                solidAngleUnit: SolidAngleUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit)
                        .major(solidAngleUnit))
}