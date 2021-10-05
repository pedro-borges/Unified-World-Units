package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.unit.base.DayUnit
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class RentTest
{
    @Test
    fun testFromMoneyAndTime()
    {
        assertEquals(expected = "2 £⋅d⁻¹",
                     actual = (GBP(6) / Time(amount = 3, unit = DayUnit)).toString())
        assertEquals(expected = "1.2 £⋅wk⁻¹",
                     actual = (GBP(6) * InterestRate(amount = 0.2, unit = FrequencyUnit(WeekUnit))).toString())
    }
}