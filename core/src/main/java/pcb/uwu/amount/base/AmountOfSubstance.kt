package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmountOfSubstanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class AmountOfSubstance : CompositeUnitAmount<AmountOfSubstanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(amount = this.amount + other.into(this.unit).amount,
                          unit = this.unit)

    override operator fun minus(other: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(amount = this.amount - other.into(this.unit).amount,
                          unit = this.unit)

    override operator fun times(other: Number) =
        AmountOfSubstance(amount = this.amount * other,
                          unit = this.unit)

    override operator fun div(other: Number) =
        AmountOfSubstance(amount = this.amount / other,
                          unit = this.unit)

    override fun into(unit: AmountOfSubstanceUnit) =
        AmountOfSubstance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion
}