package pcb.uwu.core

import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitCounter.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.utils.UnitAmountUtils
import pcb.uwu.utils.andThen
import pcb.uwu.utils.identity
import java.math.BigDecimal
import java.util.Objects

open class CompositeUnitAmount<U : Unit> : UnitAmount<U>
{
    final override val amount: Amount
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
            : this(Amount(amount), magnitude, unit)

    constructor(amount: Amount,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(amount.times(magnitude.amount), unit)

    constructor(amount: Amount, unit: U)
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

    override fun times(scalar: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.times(this, scalar), unit)
    }

    override fun div(scalar: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(UnitAmountUtils.dividedByScalar(this, scalar), unit)
    }

    override fun times(amount: UnitAmount<out Unit>): UnitAmount<Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<Amount>()
        for (otherUnitCount in amount.unit.unitCounter.baseUnits)
        {
            val resultUnitCount = resultUnitCounter[otherUnitCount.unit]
            if (resultUnitCount == EMPTY_BASE_UNIT_COUNT)
            {
                // New unit type, no adaptation necessary
                resultUnitCounter = resultUnitCounter.major(otherUnitCount.unit)
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
        val resultAmount = transformation(this.amount.times(amount.amount))
        return CompositeUnitAmount(resultAmount, CompositeUnit(resultUnitCounter))
    }

    override fun div(amount: UnitAmount<out Unit>): UnitAmount<Unit>
    {
        var resultUnitCounter = UnitCounter(unit.unitCounter)
        var transformation = identity<Amount>()
        for (otherUnitCount in amount.unit.unitCounter.baseUnits)
        {
            val resultUnitCount = resultUnitCounter[otherUnitCount.unit]
            if (resultUnitCount == EMPTY_BASE_UNIT_COUNT)
            {
                // New unit type, no adaptation necessary
                resultUnitCounter = resultUnitCounter.minor(otherUnitCount.unit)
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
        val resultAmount = transformation(this.amount.div(amount.amount))
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
        else this.unit.baseUnitType == that.unit.baseUnitType &&
                this.unit.toCanonical(amount) == that.unit.toCanonical(that.amount) &&
                this.unit.fromCanonical(amount) == that.unit.fromCanonical(that.amount)
    }

    // endregion

    // region Comparable

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun compareTo(that: UnitAmount<U>) =
        this.unit.toCanonical(amount).amount.compareTo(that.unit.fromCanonical(that.amount).amount)

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