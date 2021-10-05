package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test

class AmountTest
{
    @Test
    fun testConstructNumber() =
        assertEquals("1",
                     Amount(1).toString())

    @Test
    fun testPlusBig() =
        assertEquals(Amount(1001000),
                     Amount(1000000) + Amount(1000))

    @Test
    fun testPlusSmall() =
        assertEquals(Amount("0.001001"),
                     Amount("0.000001") + Amount("0.001"))

    @Test
    fun testMinusSmallerBig() =
        assertEquals(Amount(999000),
                     Amount(1000000) - Amount(1000))

    @Test
    fun testMinusHigherBig() =
        assertEquals(Amount(-999000),
                     Amount(1000) - Amount(1000000))

    @Test
    fun testMinusLowerSmall() =
        assertEquals(Amount("0.000999"),
                     Amount("0.001") - Amount("0.000001"))

    @Test
    fun testMinusHigherSmall() =
        assertEquals(Amount("-0.000999"),
                     Amount("0.000001") - Amount("0.001"))
}