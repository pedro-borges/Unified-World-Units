package pcb.uwu.unit.derived.geometry

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.AngleUnit
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit

open class SolidAngleUnit
    : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(angleUnit1: AngleUnit,
                angleUnit2: AngleUnit)
            : super(UnitCounter()
                        .major(angleUnit1)
                        .major(angleUnit2))

    constructor(luminousFluxUnit: LuminousFluxUnit,
                luminousIntensityUnit: LuminousIntensityUnit)
            : super(UnitCounter()
                        .major(luminousFluxUnit)
                        .minor(luminousIntensityUnit))

}
