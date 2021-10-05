package pcb.uwu.unit.derived.finance

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.finance.CurrencyUnit

class DebtUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(currencyUnit: CurrencyUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(currencyUnit)
                        .major(timeUnit))
}