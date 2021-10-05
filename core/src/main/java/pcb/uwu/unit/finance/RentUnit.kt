package pcb.uwu.unit.finance

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit

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