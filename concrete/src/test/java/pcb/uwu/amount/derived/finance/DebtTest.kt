package pcb.uwu.amount.derived.finance

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Weeks
import pcb.uwu.amount.finance.USD
import pcb.uwu.unit.base.WeekUnit.WEEK
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.derived.fundamental.PerDayUnit.PER_DAY
import java.math.MathContext.DECIMAL64

class DebtTest
{
    @Test
    fun multipliedByInterestRate() =
        assertEquals("84 US$",
                     Debt(amount = 60,
                          unit = DebtUnit(USD.CURRENCY, WEEK)).times(InterestRate(amount = "0.2", unit = PER_DAY), DECIMAL64).toString())

    @Test
    fun dividedByTime() =
        assertEquals("30 US$",
                     Debt(amount = 60,
                          unit = DebtUnit(USD.CURRENCY, WEEK)).div(Weeks(2), DECIMAL64).toString())

    @Test
    fun dividedByMoney() =
        assertEquals("3 wk",
                     Debt(amount = 60,
                          unit = DebtUnit(USD.CURRENCY, WEEK)).div(USD(20), DECIMAL64).toString())

}