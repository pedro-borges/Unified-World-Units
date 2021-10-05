package pcb.uwu.amount.derived.finance

import pcb.uwu.amount.base.Weeks
import pcb.uwu.amount.base.currency.USD
import pcb.uwu.unit.base.CurrencyUnit.Companion.USD
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.derived.fundamental.PerDayUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class DebtTest
{
    @Test
    fun multipliedByInterestRate() =
        assertEquals(expected = USD(amount = 84),
                     actual = Debt(amount = 60, unit = DebtUnit(USD, WeekUnit)) * InterestRate(amount = 0.2,
                                                                                               unit = PerDayUnit))

    @Test
    fun dividedByTime() =
        assertEquals(expected = USD(30),
                     actual = Debt(amount = 60, unit = DebtUnit(USD, WeekUnit)) / Weeks(2))

    @Test
    fun dividedByMoney() =
        assertEquals(expected = Weeks(3),
                     actual = Debt(amount = 60, unit = DebtUnit(USD, WeekUnit)) / USD(20))

}