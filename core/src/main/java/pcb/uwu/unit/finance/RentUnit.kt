package pcb.uwu.unit.finance

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit

class RentUnit : CompositeUnit
{
    constructor(money: CurrencyUnit,
                time: TimeUnit)
            : super(UnitCounter()
                        .major(money)
                        .minor(time))

    constructor(money: CurrencyUnit,
                interestRateUnit: FrequencyUnit)
            : super(UnitCounter()
                        .major(money)
                        .major(interestRateUnit))
}