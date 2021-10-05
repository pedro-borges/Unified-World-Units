package pcb.uwu.contract

import java.math.BigDecimal
import java.util.Currency

fun interface CurrencyConversionProvider
{
    fun getRatio(originalCurrency: Currency, destinationCurrency: Currency): BigDecimal
}