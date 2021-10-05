package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import kotlin.reflect.KClass

open class AngleUnit(symbol: String,
                     singularName: String,
                     pluralName: String,
                     translationToCanonical: (Amount) -> Amount,
                     translationFromCanonical: (Amount) -> Amount)
    : ScalarUnit(symbol = symbol,
                 singularName = singularName,
                 pluralName = pluralName,
                 translationToCanonical = translationToCanonical,
                 translationFromCanonical = translationFromCanonical)
{
    override val unitCounter: UnitCounter
        get() = UnitCounter()
    override val baseUnitType: KClass<out BaseUnit> = AngleUnit::class
}