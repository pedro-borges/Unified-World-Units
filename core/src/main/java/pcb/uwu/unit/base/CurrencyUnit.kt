package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.exception.InvalidCurrencyException
import kotlin.reflect.KClass

class CurrencyUnit(val code: String,
                   symbol: String,
                   singleName: String,
                   pluralName: String,
                   val defaultFractionDigits: Int)
    : BaseUnit(precedence = 0,
               symbol = symbol,
               singularName = singleName,
               pluralName = pluralName,
               translationToCanonical = { throw InvalidCurrencyException("Cannot convert currencies") },
               translationFromCanonical = { throw InvalidCurrencyException("Cannot convert currencies") })
{
    override val unitCounter: UnitCounter
        get() = UnitCounter(this)

    override val translationToCanonical: (Amount) -> Amount
        get() = throw InvalidCurrencyException("Dynamic currency conversion is not possible")

    override val translationFromCanonical: (Amount) -> Amount
        get() = throw InvalidCurrencyException("Dynamic currency conversion is not possible")

    override val baseUnitType: KClass<out BaseUnit> = CurrencyUnit::class

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?) =
        if (that is CurrencyUnit) code == that.code
        else false

    override fun hashCode() =
        code.hashCode()

    // endregion

    companion object
    {
        val AUD = CurrencyUnit(code = "AUD",
                               symbol = "AU$",
                               singleName = "Australian Dollar",
                               pluralName = "Australian Dollars",
                               defaultFractionDigits = 2)
        val BTC = CurrencyUnit(code = "BTC",
                               symbol = "₿",
                               singleName = "BitCoin",
                               pluralName = "BitCoins",
                               defaultFractionDigits = 8)
        val CAD = CurrencyUnit(code = "CAD",
                               symbol = "CA$",
                               singleName = "Canadian Dollar",
                               pluralName = "Canadian Dollars",
                               defaultFractionDigits = 2)
        val CHF = CurrencyUnit(code = "CHF",
                               symbol = "CHF",
                               singleName = "Swiss Franc",
                               pluralName = "Swiss Francs",
                               defaultFractionDigits = 2)
        val EUR = CurrencyUnit(code = "EUR",
                               symbol = "€",
                               singleName = "Euro",
                               pluralName = "Euros",
                               defaultFractionDigits = 2)
        val GBP = CurrencyUnit(code = "GBP",
                               symbol = "£",
                               singleName = "Pound Sterling",
                               pluralName = "Pounds Sterling",
                               defaultFractionDigits = 2)
        val JPY = CurrencyUnit(code = "JPY",
                               symbol = "¥",
                               singleName = "Japanese Yen",
                               pluralName = "Japanese Yens",
                               defaultFractionDigits = 4)
        val USD = CurrencyUnit(code = "USD",
                               symbol = "US$",
                               singleName = "United States Dollar",
                               pluralName = "United States Dollars",
                               defaultFractionDigits = 2)
    }
}