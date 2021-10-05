package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class ElectricCurrentUnit(symbol: String,
                               singularName: String,
                               pluralName: String,
                               translationToCanonical: Function<Amount, Amount>,
                               translationFromCanonical: Function<Amount, Amount>)
    : BaseUnit(4, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter(this)
    override val baseUnitType = ElectricCurrentUnit::class.java
}