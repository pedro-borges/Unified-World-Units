package pcb.uwu.amount.derived.economics

import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.DayUnit
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.acoustics.FrequencyUnit
import pcb.uwu.unit.derived.economics.GBPUnit
import pcb.uwu.unit.derived.economics.RentUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class RentTest
{
    @Test
    fun testFromMoneyAndTime()
    {
        assertEquals(expected = Rent(amount = 2, unit = RentUnit(GBPUnit, DayUnit)),
                     actual = GBP(6) / Time(amount = 3, unit = DayUnit))

        assertEquals(expected = Rent(amount = 1.2, unit = RentUnit(GBPUnit, WeekUnit)),
                     actual = GBP(6) * InterestRate(amount = 0.2, unit = FrequencyUnit(WeekUnit)))
    }
}