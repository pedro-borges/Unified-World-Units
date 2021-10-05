package pcb.uwu.unit.finance

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.UnitCounter
import pcb.uwu.exception.InvalidCurrencyException
import java.util.Currency
import java.util.function.Function

class CurrencyUnit(val currency: Currency)
    : BaseUnit(0,
               currency.symbol,
               currency.displayName,
               currency.displayName,
               Function { throw InvalidCurrencyException("Cannot convert currencies") },
               Function { throw InvalidCurrencyException("Cannot convert currencies") })
{
    override val unitCounter: UnitCounter
        get() = UnitCounter(this)

    override val translationToCanonical: Function<BigDecimalAmount, BigDecimalAmount>
        get() = throw InvalidCurrencyException("Dynamic currency conversion is not possible")

    override val translationFromCanonical: Function<BigDecimalAmount, BigDecimalAmount>
        get() = throw InvalidCurrencyException("Dynamic currency conversion is not possible")

    override val baseUnitType = CurrencyUnit::class.java

    val defaultFractionDigits = currency.defaultFractionDigits

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?): Boolean
    {
        if (that is CurrencyUnit)
        {
            return currency == that.currency
        }
        return false
    }

    override fun hashCode(): Int
    {
        return currency.hashCode()
    }

    companion object
    {
        val GBP = of("GBP")
        val USD = of("USD")
        val EUR = of("EUR")
        val CANONICAL_CURRENCY = GBP

        @JvmStatic
        fun of(code: String): CurrencyUnit
        {
            return CurrencyUnit(Currency.getInstance(code))
        }
    }
}