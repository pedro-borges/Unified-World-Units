package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Amount
import kotlin.test.Test
import kotlin.test.assertEquals

class GBPTest
{
    @Test
    fun testConstructHonoursDefaultFractionDigits()
    {
        assertEquals(expected = Amount(1),
                     actual = GBP(1.005).amount)
        assertEquals(expected = Amount(1),
                     actual = GBP(0.995).amount)
    }

    // endregion
    @Test
    fun testPlusSameCurrency() =
        assertEquals(expected = GBP(11),
                     actual = GBP(1) + GBP(10))

    @Test
    fun testMinusSameCurrency() =
        assertEquals(expected = GBP(-9),
                     actual = GBP(1) - GBP(10))
}