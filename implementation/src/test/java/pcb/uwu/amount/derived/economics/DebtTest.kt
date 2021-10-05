package pcb.uwu.amount.derived.economics

import pcb.uwu.amount.base.Weeks
import pcb.uwu.unit.base.WeekUnit
import pcb.uwu.unit.derived.economics.DebtUnit
import pcb.uwu.unit.derived.economics.USDUnit
import pcb.uwu.unit.derived.geometry.PerDayUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class DebtTest
{
    @Test
    fun multipliedByInterestRate() =
        assertEquals(expected = USD(amount = 84),
                     actual = Debt(amount = 60, unit = DebtUnit(USDUnit, WeekUnit)) * InterestRate(amount = 0.2,
                                                                                                   unit = PerDayUnit))

    @Test
    fun dividedByTime() =
        assertEquals(expected = USD(30),
                     actual = Debt(amount = 60, unit = DebtUnit(USDUnit, WeekUnit)) / Weeks(2))

    @Test
    fun dividedByMoney() =
        assertEquals(expected = Weeks(3),
                     actual = Debt(amount = 60, unit = DebtUnit(USDUnit, WeekUnit)) / USD(20))

}