package pcb.uwu.core

import pcb.uwu.util.andThen
import pcb.uwu.util.identity
import kotlin.reflect.KClass

open class CompositeUnit(final override val unitCounter: UnitCounter = UnitCounter())
    : Unit
{
    // region public methods

    fun major(unit: BaseUnit) =
        CompositeUnit(unitCounter.major(unit))

    fun minor(unit: BaseUnit) =
        CompositeUnit(unitCounter.minor(unit))

    // endregion

    // region Unit

    override val symbol = unitCounter.asString(Unit::symbol, Unit::symbol)

    override val singularName = unitCounter.asString(Unit::singularName, Unit::singularName)

    override val pluralName = unitCounter.asString(Unit::pluralName, Unit::singularName)

    override val translationToCanonical: (Amount) -> Amount
        get()
        {
            var result = identity<Amount>()
            for (unitCount in unitCounter.baseUnits)
            {
                val unit = unitCount.unit
                val count = unitCount.count
                if (count > 0)
                {
                    for (i in 0 until count)
                    {
                        result = result.andThen(unit.translationToCanonical)
                    }
                }
                else if (count < 0)
                {
                    for (i in 0 downTo count + 1)
                    {
                        result = result.andThen(unit.translationFromCanonical)
                    }
                }
            }
            return result
        }

    override val translationFromCanonical: (Amount) -> Amount
        get()
        {
            var result = identity<Amount>()
            for (unitCount in unitCounter.baseUnits)
            {
                val unit = unitCount.unit
                val count = unitCount.count
                if (count > 0)
                {
                    for (i in 0 until count)
                    {
                        result = result.andThen(unit.translationFromCanonical)
                    }
                }
                else if (count < 0)
                {
                    for (i in 0 downTo count + 1)
                    {
                        result = result.andThen(unit.translationToCanonical)
                    }
                }
            }
            return result
        }

    override val isScalar = unitCounter.isEmpty

    override val baseUnitType: KClass<out BaseUnit>
        get() = throw IllegalStateException()

    // endregion

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?): Boolean
    {
        if (this === that) return true
        if (that !is Unit) return false
        return unitCounter == that.unitCounter &&
                translationFromCanonical(Amount.ONE) == that.translationFromCanonical(Amount.ONE) &&
                translationToCanonical(Amount.ONE) == that.translationToCanonical(Amount.ONE)
    }

    override fun hashCode() =
        unitCounter.hashCode()

    override fun toString() =
        symbol

    // endregion
}