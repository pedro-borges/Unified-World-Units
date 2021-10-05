package pcb.uwu.core

import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.util.UnitAmountUtils
import pcb.uwu.util.andThen
import pcb.uwu.util.hash
import pcb.uwu.util.identity

open class CompositeUnitAmount<U : Unit> : UnitAmount<U>
{
    final override val amount: Amount
    final override val unit: U

    // region constructors

    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(Amount(amount), magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: U)
            : this(Amount(amount), magnitude, unit)

    internal constructor(amount: Amount,
                        magnitude: Magnitude = NATURAL,
                        unit: U)
    {
        this.amount = amount.times(magnitude.amount)
        this.unit = unit
    }

    // endregion

    // region UnitAmount

    override fun plus(amount: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(amount = UnitAmountUtils.plusAmount(this, amount),
                                   unit = unit)
    }

    override fun minus(amount: UnitAmount<U>): UnitAmount<U>
    {
        return CompositeUnitAmount(amount = UnitAmountUtils.minusAmount(this, amount),
                                   unit = unit)
    }

    override fun times(scalar: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(amount = UnitAmountUtils.times(this, scalar),
                                   unit = unit)
    }

    override fun div(scalar: Number): UnitAmount<U>
    {
        return CompositeUnitAmount(amount = UnitAmountUtils.dividedByScalar(this, scalar),
                                   unit = unit)
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

        return CompositeUnitAmount(amount = transformation(this.amount.times(amount.amount)),
                                   unit = CompositeUnit(resultUnitCounter))
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

        return CompositeUnitAmount(amount = transformation(this.amount.div(amount.amount)),
                                   unit = CompositeUnit(resultUnitCounter))
    }

    override fun invert(): UnitAmount<out Unit>
    {
        return CompositeUnitAmount(amount = amount.invert(),
                                   unit = CompositeUnit(unit.unitCounter.invert()))
    }

    override fun to(unit: U): UnitAmount<U>
    {
        return CompositeUnitAmount(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                                   unit = unit)
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
        return this.unit.unitCounter == that.unit.unitCounter &&
                this.unit.toCanonical(this.amount) == that.unit.toCanonical(that.amount)
    }

    override fun hashCode(): Int
    {
        return hash(amount, unit)
    }

    override fun toString() =
        "$amount${if (unit.isScalar) "" else " $unit"}"
}