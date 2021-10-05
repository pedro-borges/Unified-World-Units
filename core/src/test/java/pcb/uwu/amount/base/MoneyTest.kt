package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.exception.InvalidCurrencyException
import pcb.uwu.unit.finance.CurrencyUnit.GBP
import pcb.uwu.unit.finance.CurrencyUnit.USD
import java.math.MathContext.UNLIMITED

class MoneyTest
{
    // region test constructors
    @Test
    fun testConstructHonoursDefaultFractionDigits()
    {
        assertEquals(BigDecimalAmount("1.00"), Money("1.005", GBP).amount)
        assertEquals(BigDecimalAmount("1.00"), Money("0.995", GBP).amount)
    }

    // endregion
    @Test
    fun testPlusSameCurrency() =
        assertEquals(Money(11, GBP),
                     Money(1, GBP).plus(Money(10, GBP), UNLIMITED))

    @Test(expected = InvalidCurrencyException::class)
    fun testPlusDifferentCurrency()
    {
        Money(1, GBP).plus(Money(10, USD), UNLIMITED)
    }

    @Test
    fun testMinusSameCurrency() =
        assertEquals(Money(-9, GBP),
                     Money(1, GBP).minus(Money(10, GBP), UNLIMITED))

    @Test(expected = InvalidCurrencyException::class)
    fun testMinusDifferentCurrency()
    {
        Money(1, GBP).minus(Money(10, USD), UNLIMITED)
    }
}