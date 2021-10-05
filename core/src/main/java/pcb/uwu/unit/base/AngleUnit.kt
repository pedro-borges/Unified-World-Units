package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class AngleUnit(symbol: String,
                     singularName: String,
                     pluralName: String,
                     translationToCanonical: Function<Amount, Amount>,
                     translationFromCanonical: Function<Amount, Amount>)
    : BaseUnit(precedence = 10,
               symbol = symbol,
               singularName = singularName,
               pluralName = pluralName,
               translationToCanonical = translationToCanonical,
               translationFromCanonical = translationFromCanonical)
{
    override val unitCounter: UnitCounter
        get() = UnitCounter()
    override val baseUnitType = AngleUnit::class.java
}