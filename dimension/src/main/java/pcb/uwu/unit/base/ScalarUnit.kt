package pcb.uwu.unit.base

import pcb.uwu.core.Amount
import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.util.identity
import kotlin.reflect.KClass


open class ScalarUnit(symbol: String = "",
                 singularName: String = "",
                 pluralName: String = "",
                 translationToCanonical: (Amount) -> Amount = identity(),
                 translationFromCanonical: (Amount) ->Amount = identity())
    : BaseUnit(precedence = 0,
               symbol = symbol,
               singularName = singularName,
               pluralName = pluralName,
               translationToCanonical = translationToCanonical,
               translationFromCanonical = translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter()
    override val baseUnitType: KClass<out BaseUnit> = ScalarUnit::class
}
