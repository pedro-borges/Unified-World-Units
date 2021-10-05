package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test

class BigDecimalAmountTest
{
    @Test
    fun testConstructNumber() =
        assertEquals("1",
                     BigDecimalAmount(1).toString())

    @Test
    fun testPlusBig() =
        assertEquals(BigDecimalAmount(1001000),
                     BigDecimalAmount(1000000) + BigDecimalAmount(1000))

    @Test
    fun testPlusSmall() =
        assertEquals(BigDecimalAmount("0.001001"),
                     BigDecimalAmount("0.000001") + BigDecimalAmount("0.001"))

    @Test
    fun testMinusSmallerBig() =
        assertEquals(BigDecimalAmount(999000),
                     BigDecimalAmount(1000000) - BigDecimalAmount(1000))

    @Test
    fun testMinusHigherBig() =
        assertEquals(BigDecimalAmount(-999000),
                     BigDecimalAmount(1000) - BigDecimalAmount(1000000))

    @Test
    fun testMinusLowerSmall() =
        assertEquals(BigDecimalAmount("0.000999"),
                     BigDecimalAmount("0.001") - BigDecimalAmount("0.000001"))

    @Test
    fun testMinusHigherSmall() =
        assertEquals(BigDecimalAmount("-0.000999"),
                     BigDecimalAmount("0.000001") - BigDecimalAmount("0.001"))
}