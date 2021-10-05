package pcb.uwu.core

import kotlin.test.Test
import kotlin.test.assertEquals

class AmountTest
{
    @Test
    fun testConstructNumber() =
        assertEquals(expected = "1",
                     actual = Amount(1).toString())

    @Test
    fun testPlusBig() =
        assertEquals(expected = Amount(value = 1001000),
                     actual = Amount(1000000) + Amount(1000))

    @Test
    fun testPlusSmall() =
        assertEquals(expected = Amount(value = "0.001001"),
                     actual = Amount("0.000001") + Amount("0.001"))

    @Test
    fun testMinusSmallerBig() =
        assertEquals(expected = Amount(value = 999000),
                     actual = Amount(1000000) - Amount(1000))

    @Test
    fun testMinusHigherBig() =
        assertEquals(expected = Amount(value = -999000),
                     actual = Amount(1000) - Amount(1000000))

    @Test
    fun testMinusLowerSmall() =
        assertEquals(expected = Amount(value = "0.000999"),
                     actual = Amount("0.001") - Amount("0.000001"))

    @Test
    fun testMinusHigherSmall() =
        assertEquals(expected = Amount(value = "-0.000999"),
                     actual = Amount("0.000001") - Amount("0.001"))
}