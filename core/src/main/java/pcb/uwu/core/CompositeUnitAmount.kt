package pcb.uwu.core

import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitCounter.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.util.Objects
import java.util.function.Function.identity

open class CompositeUnitAmount<U : Unit> : UnitAmount<U>
{
    final override val amount: BigDecimalAmount
    final override val unit: U

    // region constructors

    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(amount.toString(), magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(BigDecimal(amount), magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(BigDecimalAmount(amount), magnitude, unit)

    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(amount.times(magnitude.value), unit)

    constructor(amount: BigDecimalAmount, unit: U)
    {
        this.amount = amount
        this.unit = unit
    }

    // endregion

    // region UnitAmount

    override operator fun plus(other: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.plusAmount(this, other), unit)
    }

    override operator fun minus(other: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.minusAmount(this, other), unit)
    }

    override operator fun times(other: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.times(this, other), unit)
    }

    override operator fun div(other: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.dividedByScalar(this, other), unit)
    }

    override operator fun times(other: UnitAmount<out Unit>): UnitAmount<out Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<BigDecimalAmount>()
        for (otherUnitCount in other.unit.unitCounter.baseUnits)
        {
            val resultUnitCount = resultUnitCounter[otherUnitCount.unit]
            if (resultUnitCount == EMPTY_BASE_UNIT_COUNT)
            {
                // New unit type, no adaptation necessary
                resultUnitCounter = resultUnitCounter.major(otherUnitCount.unit, otherUnitCount.count)
                continue
            }

            // Existing unit type, adaptation is necessary
            var resultMagnitude = resultUnitCount.count
            var otherMagnitude = otherUnitCount.count

            // other is major and this is major
            while (otherMagnitude > 0 && resultMagnitude > 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationToCanonical)
                        .andThen(resultUnitCount.unit.translationFromCanonical)
                }
                resultUnitCounter = resultUnitCounter.major(resultUnitCount.unit)
                resultMagnitude++
                otherMagnitude--
            }

            // other is minor and this is minor
            while (otherMagnitude < 0 && resultMagnitude < 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationFromCanonical)
                        .andThen(resultUnitCount.unit.translationToCanonical)
                }
                resultUnitCounter = resultUnitCounter.minor(resultUnitCount.unit)
                resultMagnitude--
                otherMagnitude++
            }

            // other is major and this is minor
            while (otherMagnitude > 0 && resultMagnitude < 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationToCanonical)
                        .andThen(resultUnitCount.unit.translationFromCanonical)
                }
                resultUnitCounter = resultUnitCounter.major(resultUnitCount.unit)
                resultMagnitude++
                otherMagnitude--
            }

            // other is minor and this is major
            while (otherMagnitude < 0 && resultMagnitude > 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationFromCanonical)
                        .andThen(resultUnitCount.unit.translationToCanonical)
                }
                resultUnitCounter = resultUnitCounter.minor(resultUnitCount.unit)
                resultMagnitude--
                otherMagnitude++
            }

            // other still has majors and this is exhausted
            while (otherMagnitude > 0)
            {
                resultUnitCounter = resultUnitCounter.major(otherUnitCount.unit)
                otherMagnitude--
            }

            // other still has minors and this is exhausted
            while (otherMagnitude < 0)
            {
                resultUnitCounter = resultUnitCounter.minor(otherUnitCount.unit)
                otherMagnitude++
            }
        }
        val resultAmount = transformation.apply(amount.times(other.amount))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override operator fun div(other: UnitAmount<out Unit>): UnitAmount<out Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<BigDecimalAmount>()
        for (otherUnitCount in other.unit.unitCounter.baseUnits)
        {
            val resultUnitCount = resultUnitCounter[otherUnitCount.unit]
            if (resultUnitCount == EMPTY_BASE_UNIT_COUNT)
            {
                // New unit type, no adaptation necessary
                resultUnitCounter = resultUnitCounter.minor(otherUnitCount.unit, otherUnitCount.count)
                continue
            }

            // Existing unit type, adaptation is necessary
            var resultMagnitude = resultUnitCount.count
            var otherMagnitude = otherUnitCount.count

            // other is major and this is major
            while (otherMagnitude > 0 && resultMagnitude > 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationFromCanonical)
                        .andThen(resultUnitCount.unit.translationToCanonical)
                }
                resultUnitCounter = resultUnitCounter.minor(resultUnitCount.unit)
                resultMagnitude--
                otherMagnitude--
            }

            // other is minor and this is minor
            while (otherMagnitude < 0 && resultMagnitude < 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationToCanonical)
                        .andThen(resultUnitCount.unit.translationFromCanonical)
                }
                resultUnitCounter = resultUnitCounter.major(resultUnitCount.unit)
                resultMagnitude++
                otherMagnitude++
            }

            // other is major and this is minor
            while (otherMagnitude > 0 && resultMagnitude < 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationFromCanonical)
                        .andThen(resultUnitCount.unit.translationToCanonical)
                }
                resultUnitCounter = resultUnitCounter.minor(resultUnitCount.unit)
                resultMagnitude--
                otherMagnitude--
            }

            // other is minor and this is major
            while (otherMagnitude < 0 && resultMagnitude > 0)
            {
                if (otherUnitCount.unit != resultUnitCount.unit)
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationToCanonical)
                        .andThen(resultUnitCount.unit.translationFromCanonical)
                }
                resultUnitCounter = resultUnitCounter.major(resultUnitCount.unit)
                resultMagnitude++
                otherMagnitude++
            }

            // other still has majors and this is exhausted
            while (otherMagnitude > 0)
            {
                resultUnitCounter = resultUnitCounter.minor(otherUnitCount.unit)
                otherMagnitude--
            }

            // other still has minors and this is exhausted
            while (otherMagnitude < 0)
            {
                resultUnitCounter = resultUnitCounter.major(otherUnitCount.unit)
                otherMagnitude++
            }
        }
        val resultAmount = transformation.apply(amount.div(other.amount))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override fun invert(): UnitAmount<out Unit>
    {
        return CompositeUnitAmount(
                amount.invert(),
                CompositeUnit(unit.unitCounter.invert()))
    }

    override fun into(unit: U): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit), unit)
    }

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun isEquivalentTo(that: UnitAmount<*>): Boolean
    {
        return if (this === that) true
        else unit.baseUnitType == that.unit.baseUnitType &&
                unit.translationToCanonical.apply(amount) == that.unit.translationToCanonical.apply(that.amount)
    }

    // endregion

    // region Comparable

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun compareTo(that: UnitAmount<U>) =
        this.unit.toCanonical(amount).value.compareTo(that.unit.fromCanonical(that.amount).value)

    // endregion

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?): Boolean
    {
        if (this === that) return true
        if (that !is UnitAmount<*>) return false
        return amount == that.amount &&
                unit == that.unit
    }

    override fun hashCode(): Int
    {
        return Objects.hash(amount, unit)
    }

    override fun toString() =
        "$amount${if (unit.isScalar) "" else " $unit"}"
}