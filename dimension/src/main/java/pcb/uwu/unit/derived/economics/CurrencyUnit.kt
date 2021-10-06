package pcb.uwu.unit.derived.economics

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.util.identity
import kotlin.reflect.KClass

open class CurrencyUnit(val code: String,
                        symbol: String,
                        singleName: String,
                        pluralName: String,
                        val defaultFractionDigits: Int)
    : BaseUnit(precedence = 0,
               symbol = symbol,
               singularName = singleName,
               pluralName = pluralName,
               translationToCanonical = identity(),
               translationFromCanonical = identity())
{
    override val unitCounter: UnitCounter
        get() = UnitCounter(this)

    override val baseUnitType: KClass<out BaseUnit> = CurrencyUnit::class

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?) =
        if (that is CurrencyUnit) code == that.code
        else false

    override fun hashCode() =
        code.hashCode()

    // endregion
}
