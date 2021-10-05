package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class LuminousIntensityUnit(symbol: String,
                                 singularName: String,
                                 pluralName: String,
                                 translationToCanonical: Function<Amount, Amount>,
                                 translationFromCanonical: Function<Amount, Amount>)
    : BaseUnit(precedence = 6,
               symbol = symbol,
               singularName = singularName,
               pluralName = pluralName,
               translationToCanonical = translationToCanonical,
               translationFromCanonical = translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter(this)
    override val baseUnitType = LuminousIntensityUnit::class.java
}