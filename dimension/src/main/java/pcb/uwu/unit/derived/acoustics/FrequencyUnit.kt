package pcb.uwu.unit.derived.acoustics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit

open class FrequencyUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(timeUnit: TimeUnit)
            : super(UnitCounter().minor(timeUnit))
}
