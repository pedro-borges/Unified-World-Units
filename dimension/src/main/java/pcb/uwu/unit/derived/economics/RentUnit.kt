package pcb.uwu.unit.derived.economics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.acoustics.FrequencyUnit

class RentUnit : CompositeUnit
{
    constructor(currency: CurrencyUnit,
                time: TimeUnit)
            : super(UnitCounter()
                        .major(currency)
                        .minor(time))

    constructor(currency: CurrencyUnit,
                interestRateUnit: FrequencyUnit)
            : super(UnitCounter()
                        .major(currency)
                        .major(interestRateUnit))
}