package pcb.uwu.unit.derived.economics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit

class DebtUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(currencyUnit: CurrencyUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(currencyUnit)
                        .major(timeUnit))
}