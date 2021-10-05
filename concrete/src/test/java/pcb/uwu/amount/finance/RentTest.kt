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
                     GBP(6).dividedBy(Time(3, DAY), DECIMAL64).toString())
        assertEquals("1.2 £⋅wk⁻¹",
                     GBP(6).multipliedBy(InterestRate(0.2, FrequencyUnit(WEEK)), DECIMAL64).toString())
    }
}