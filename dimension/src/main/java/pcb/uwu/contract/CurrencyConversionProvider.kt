package pcb.uwu.contract

import pcb.uwu.unit.derived.economics.CurrencyUnit
import java.math.BigDecimal

fun interface CurrencyConversionProvider
{
    fun getRatio(originalCurrency: CurrencyUnit, destinationCurrency: CurrencyUnit): BigDecimal
}
