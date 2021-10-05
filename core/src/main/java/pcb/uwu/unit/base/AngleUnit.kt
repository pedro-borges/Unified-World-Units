package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter

open class AngleUnit(symbol: String,
                     singularName: String,
                     pluralName: String,
                     translationToCanonical: (Amount) -> Amount,
                     translationFromCanonical: (Amount) -> Amount)
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