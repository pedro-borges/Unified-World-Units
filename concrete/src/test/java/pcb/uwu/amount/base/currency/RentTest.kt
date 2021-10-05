package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.amount.derived.finance.Rent
import pcb.uwu.unit.base.CurrencyUnit.Companion.GBP
import pcb.uwu.unit.base.DayUnit
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.unit.finance.RentUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class RentTest
{
    @Test
    fun testFromMoneyAndTime()
    {
        assertEquals(expected = Rent(amount = 2, unit = RentUnit(GBP, DayUnit)),
                     actual = GBP(6) / Time(amount = 3, unit = DayUnit))

        assertEquals(expected = Rent(amount = 1.2, unit = RentUnit(GBP, WeekUnit)),
                     actual = GBP(6) * InterestRate(amount = 0.2, unit = FrequencyUnit(WeekUnit)))
    }
}