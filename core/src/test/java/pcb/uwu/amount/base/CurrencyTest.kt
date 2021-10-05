package pcb.uwu.amount.base

import pcb.uwu.core.Amount
import pcb.uwu.unit.base.CurrencyUnit.Companion.GBP
import kotlin.test.Test
import kotlin.test.assertEquals

class CurrencyTest
{
    // region test constructors
    @Test
    fun testConstructHonoursDefaultFractionDigits()
    {
        assertEquals(Amount("1.00"), Currency(amount = "1.005", unit = GBP).amount)
        assertEquals(Amount("1.00"), Currency(amount = "0.995", unit = GBP).amount)
    }

    // endregion
    @Test
    fun testPlusSameCurrency() =
        assertEquals(Currency(amount = 11, unit = GBP),
                     Currency(amount = 1, unit = GBP) + Currency(amount = 10, unit = GBP))

    @Test
    fun testMinusSameCurrency() =
        assertEquals(Currency(amount = -9, unit = GBP),
                     Currency(amount = 1, unit = GBP) - Currency(amount = 10, unit = GBP))
}