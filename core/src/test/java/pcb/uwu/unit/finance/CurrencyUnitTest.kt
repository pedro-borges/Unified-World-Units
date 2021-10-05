package pcb.uwu.unit.finance

import pcb.uwu.core.Amount.Companion.ZERO
import pcb.uwu.exception.InvalidCurrencyException
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.AUD
import pcb.uwu.unit.base.CurrencyUnit.Companion.BTC
import pcb.uwu.unit.base.CurrencyUnit.Companion.CAD
import pcb.uwu.unit.base.CurrencyUnit.Companion.CHF
import pcb.uwu.unit.base.CurrencyUnit.Companion.EUR
import pcb.uwu.unit.base.CurrencyUnit.Companion.GBP
import pcb.uwu.unit.base.CurrencyUnit.Companion.JPY
import pcb.uwu.unit.base.CurrencyUnit.Companion.USD
import kotlin.test.Test
import kotlin.test.assertFailsWith

class CurrencyUnitTest
{
    @Test
    fun testNoCanonical()
    {
        assertNoCanonical(AUD)
        assertNoCanonical(BTC)
        assertNoCanonical(CAD)
        assertNoCanonical(CHF)
        assertNoCanonical(EUR)
        assertNoCanonical(GBP)
        assertNoCanonical(JPY)
        assertNoCanonical(USD)
    }

    private fun assertNoCanonical(currencyUnit: CurrencyUnit)
    {
        assertFailsWith(InvalidCurrencyException::class) { currencyUnit.toCanonical(ZERO) }
        assertFailsWith(InvalidCurrencyException::class) { currencyUnit.fromCanonical(ZERO) }
    }
}