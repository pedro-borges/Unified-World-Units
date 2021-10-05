package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit

open class LuminousEnergyUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(luminousFluxUnit: LuminousFluxUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(luminousFluxUnit)
                        .major(timeUnit))
}