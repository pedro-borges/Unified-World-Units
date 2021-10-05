package pcb.uwu.amount.finance

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.unit.base.DayUnit.DAY
import pcb.uwu.unit.base.WeekUnit.WEEK
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import java.math.MathContext.DECIMAL64

class RentTest
{
    @Test
    fun testFromMoneyAndTime()
    {
        assertEquals("2 £⋅d⁻¹",
                     GBP(6).div(Time(amount = 3, unit = DAY), DECIMAL64).toString())
        assertEquals("1.2 £⋅wk⁻¹",
                     GBP(6).multiply(InterestRate(amount = 0.2, unit = FrequencyUnit(WEEK)), DECIMAL64).toString())
    }
}