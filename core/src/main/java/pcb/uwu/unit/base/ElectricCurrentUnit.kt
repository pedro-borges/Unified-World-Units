package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter

open class ElectricCurrentUnit(symbol: String,
                               singularName: String,
                               pluralName: String,
                               translationToCanonical: (Amount) -> Amount,
                               translationFromCanonical: (Amount) -> Amount)
    : BaseUnit(precedence = 4,
               symbol = symbol,
               singularName = singularName,
               pluralName = pluralName,
               translationToCanonical = translationToCanonical,
               translationFromCanonical = translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter(this)
    override val baseUnitType = ElectricCurrentUnit::class.java
}