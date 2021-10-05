package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.finance.Currency
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.exception.InvalidCurrencyException
import pcb.uwu.unit.finance.CurrencyUnit.Companion.GBP
import pcb.uwu.unit.finance.CurrencyUnit.Companion.USD

class CurrencyTest
{
    // region test constructors
    @Test
    fun testConstructHonoursDefaultFractionDigits()
    {
        assertEquals(BigDecimalAmount("1.00"), Currency("1.005", GBP).amount)
        assertEquals(BigDecimalAmount("1.00"), Currency("0.995", GBP).amount)
    }

    // endregion
    @Test
    fun testPlusSameCurrency() =
        assertEquals(Currency(11, GBP),
                     Currency(1, GBP) + Currency(10, GBP))

    @Test(expected = InvalidCurrencyException::class)
    fun testPlusDifferentCurrency()
    {
        Currency(1, GBP) + Currency(10, USD)
    }

    @Test
    fun testMinusSameCurrency() =
        assertEquals(Currency(-9, GBP),
                     Currency(1, GBP) - Currency(10, GBP))

    @Test(expected = InvalidCurrencyException::class)
    fun testMinusDifferentCurrency()
    {
        Currency(1, GBP) - Currency(10, USD)
    }
}