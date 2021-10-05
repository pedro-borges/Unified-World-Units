package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class AmountOfSubstanceUnit(symbol: String,
                                 singularName: String,
                                 pluralName: String,
                                 translationToCanonical: Function<Amount, Amount>,
                                 translationFromCanonical: Function<Amount, Amount>)
    : BaseUnit(precedence = 1,
               symbol = symbol,
               singularName = singularName,
               pluralName = pluralName,
               translationToCanonical = translationToCanonical,
               translationFromCanonical = translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter(this)
    override val baseUnitType = AmountOfSubstanceUnit::class.java
}