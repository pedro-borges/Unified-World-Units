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

    override fun plus(amount: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.plusAmount(this, amount), unit)
    }

    override fun minus(amount: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.minusAmount(this, amount), unit)
    }

    override fun times(number: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.times(this, number), unit)
    }

    override fun div(number: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.dividedByScalar(this, number), unit)
    }

    override fun times(amount: UnitAmount<out Unit>): UnitAmount<Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<BigDecimalAmount>()
        for (otherUnitCount in amount.unit.unitCounter.baseUnits)
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
        val resultAmount = transformation.apply(this.amount.times(amount.amount))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override fun div(amount: UnitAmount<out Unit>): UnitAmount<Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<BigDecimalAmount>()
        for (otherUnitCount in amount.unit.unitCounter.baseUnits)
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
        val resultAmount = transformation.apply(this.amount.div(amount.amount))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override fun invert(): UnitAmount<out Unit>
    {
        return CompositeUnitAmount(
                amount.invert(),
                CompositeUnit(unit.unitCounter.invert()))
    }

    override fun to(unit: U): UnitAmount<U>
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