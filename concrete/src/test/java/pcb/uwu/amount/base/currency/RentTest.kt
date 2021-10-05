package pcb.uwu.amount.base.currency

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.unit.base.DayUnit.DAY
import pcb.uwu.unit.base.WeekUnit.WEEK
import pcb.uwu.unit.derived.fundamental.FrequencyUnit

class RentTest
{
    @Test
    fun testFromMoneyAndTime()
    {
        assertEquals("2 £⋅d⁻¹",
                     GBP(6).div(Time(amount = 3, unit = DAY)).toString())
        assertEquals("1.2 £⋅wk⁻¹",
                     GBP(6).times(InterestRate(amount = 0.2, unit = FrequencyUnit(WEEK))).toString())
    }
}