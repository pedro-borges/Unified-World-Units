package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.TimeUnit

open class ElectricChargeUnit
    : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(timeUnit))
}