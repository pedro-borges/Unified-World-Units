package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.MathContext.UNLIMITED

class BigDecimalAmountTest
{
    @Test
    fun testConstructNumber() =
        assertEquals("1",
                     BigDecimalAmount(1).toString())

    @Test
    fun testConstructBigDecimal() =
        assertEquals("1",
                     BigDecimalAmount(1).toString())

    @Test
    fun testPlusBig() =
        assertEquals("1001000",
                     BigDecimalAmount(1000000).plus(BigDecimalAmount(1000), UNLIMITED).toString())

    @Test
    fun testPlusSmall() =
        assertEquals("0.001001",
                     BigDecimalAmount("0.000001").plus(BigDecimalAmount("0.001"), UNLIMITED).toString())

    @Test
    fun testMinusSmallerBig() =
        assertEquals("999000",
                     BigDecimalAmount(1000000).minus(BigDecimalAmount(1000), UNLIMITED).toString())

    @Test
    fun testMinusHigherBig() =
        assertEquals("-999000",
                     BigDecimalAmount(1000).minus(BigDecimalAmount(1000000), UNLIMITED).toString())

    @Test
    fun testMinusLowerSmall() =
        assertEquals("0.000999",
                     BigDecimalAmount("0.001").minus(BigDecimalAmount("0.000001"), UNLIMITED).toString())

    @Test
    fun testMinusHigherSmall() =
        assertEquals("-0.000999",
                     BigDecimalAmount("0.000001").minus(BigDecimalAmount("0.001"), UNLIMITED).toString())
}