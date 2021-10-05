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
                     Debt(60, DebtUnit(USD.CURRENCY, WEEK)).multipliedBy(InterestRate("0.2", PER_DAY), DECIMAL64).toString())

    @Test
    fun dividedByTime() =
        assertEquals("30 US$",
                     Debt(60, DebtUnit(USD.CURRENCY, WEEK)).dividedBy(Weeks(2), DECIMAL64).toString())

    @Test
    fun dividedByMoney() =
        assertEquals("3 wk",
                     Debt(60, DebtUnit(USD.CURRENCY, WEEK)).dividedBy(USD(20), DECIMAL64).toString())

}