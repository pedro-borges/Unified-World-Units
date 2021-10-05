package pcb.uwu.amount.derived.finance

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Weeks
import pcb.uwu.amount.base.currency.USD
import pcb.uwu.unit.base.CurrencyUnit.Companion.USD
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.derived.fundamental.PerDayUnit

class DebtTest
{
    @Test
    fun multipliedByInterestRate() =
        assertEquals("84 US$",
                     Debt(amount = 60,
                          unit = DebtUnit(USD, WeekUnit)).times(InterestRate(amount = "0.2", unit = PerDayUnit)).toString())

    @Test
    fun dividedByTime() =
        assertEquals("30 US$",
                     Debt(amount = 60,
                          unit = DebtUnit(USD, WeekUnit)).div(Weeks(2)).toString())

    @Test
    fun dividedByMoney() =
        assertEquals("3 wk",
                     Debt(amount = 60,
                          unit = DebtUnit(USD, WeekUnit)).div(USD(20)).toString())

}