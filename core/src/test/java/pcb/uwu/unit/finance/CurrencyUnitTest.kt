package pcb.uwu.unit.finance

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.core.BigDecimalAmount.Companion.ZERO
import pcb.uwu.exception.InvalidCurrencyException
import pcb.uwu.unit.finance.CurrencyUnit.GBP
import java.util.Currency

class CurrencyUnitTest
{
    @Test
    fun testCurrencyEquals()
    {
        assertEquals(Currency.getInstance("GBP"), GBP.currency)
    }

    @Test(expected = InvalidCurrencyException::class)
    fun testConstructorCurrency()
    {
        assertEquals("£", GBP.toString())
        GBP.translationToCanonical.apply(ZERO)
    }
}