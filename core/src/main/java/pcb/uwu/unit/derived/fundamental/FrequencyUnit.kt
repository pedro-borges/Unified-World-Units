package pcb.uwu.unit.derived.fundamental

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit

open class FrequencyUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(time: TimeUnit)
            : super(UnitCounter().minor(time))
}