package pcb.uwu.core

import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitCounter.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext
import java.math.MathContext.UNLIMITED
import java.util.Objects
import java.util.function.Function

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
            : this(amount.times(magnitude.value, UNLIMITED), unit)

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

    override fun multiply(other: BigDecimal, mathContext: MathContext): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.multipliedByScalar(this, other, mathContext), unit)
    }

    override fun div(other: BigDecimal, mathContext: MathContext): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.dividedByScalar(this, other, mathContext), unit)
    }

    override fun multiply(other: UnitAmount<out Unit>, mathContext: MathContext): UnitAmount<out Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = Function.identity<BigDecimalAmount>()
        for (otherUnitCount in other.unit.unitCounter.baseUnits)
        {
            val resultUnitCount = resultUnitCounter[otherUnitCount.unit]
            if (EMPTY_BASE_UNIT_COUNT == resultUnitCount)
            {
                // New unit type, no adaptation necessary
                resultUnitCounter.major(otherUnitCount.unit, otherUnitCount.count)
                continue
            }

            // Existing unit type, adaptation is necessary
            var resultMagnitude = resultUnitCount.count
            var otherMagnitude = otherUnitCount.count

            // other is major and this is major
            while (otherMagnitude > 0 && resultMagnitude > 0)
            {
                if (!otherUnitCount.unit.equals(resultUnitCount.unit))
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
                if (!otherUnitCount.unit.equals(resultUnitCount.unit))
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
                if (!otherUnitCount.unit.equals(resultUnitCount.unit))
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
                if (!otherUnitCount.unit.equals(resultUnitCount.unit))
                {
                    transformation = transformation
                        .andThen(otherUnitCount.unit.translationFromCanonical)
                        .andThen(resultUnitCount.unit.translationToCanonical)
                }
                resultUnitCounter = resultUnitCounter.minor(resultUnitCount.unit)
                resultMagnitude--
                otherMagnitude++
            }

            // other still exists and this is exhausted
            while (otherMagnitude > 0)
            {
                resultUnitCounter = resultUnitCounter.major(otherUnitCount.unit)
                otherMagnitude--
            }

            // other still exists and this is exhausted
            while (otherMagnitude < 0)
            {
                resultUnitCounter = resultUnitCounter.minor(otherUnitCount.unit)
                otherMagnitude++
            }
        }
        val resultAmount = transformation.apply(amount.times(other.amount, mathContext))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override fun div(other: UnitAmount<out Unit>, mathContext: MathContext): UnitAmount<out Unit>
    {
        return multiply(other.invert(mathContext), mathContext)
    }

    override fun invert(mathContext: MathContext): UnitAmount<out Unit>
    {
        return CompositeUnitAmount(
                amount.invert(mathContext),
                CompositeUnit(unit.unitCounter.invert()))
    }

    override fun into(unit: U): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.getAmountIn(this, unit), unit)
    }

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equivalentTo(that: UnitAmount<*>): Boolean
    {
        return if (this === that) true
        else unit.baseUnitType == that.unit.baseUnitType &&
                unit.translationToCanonical.apply(amount) == that.unit.translationToCanonical.apply(that.amount)
    }

    // endregion

    // region Comparable

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun compareTo(that: UnitAmount<U>) =
        unit.toCanonical(amount).value.compareTo(that.unit.fromCanonical(that.amount).value)

    // endregion

    // region Object

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is UnitAmount<*>) return false
        return amount == other.amount &&
                unit == other.unit
    }

    override fun hashCode(): Int
    {
        return Objects.hash(amount, unit)
    }

    override fun toString() =
        "$amount${if (unit.isScalar) "" else " $unit"}"
}