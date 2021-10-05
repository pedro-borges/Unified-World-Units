package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.utils.UnitAmountUtils

open class Power : CompositeUnitAmount<PowerUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<PowerUnit>) =
        Power(amount = this.amount + other.into(this.unit).amount,
              unit = this.unit)

    override operator fun minus(other: UnitAmount<PowerUnit>) =
        Power(amount = this.amount - other.into(this.unit).amount,
              unit = this.unit)

    override operator fun times(other: Number) =
        Power(amount = this.amount * other,
              unit = this.unit)

    override operator fun div(other: Number) =
        Power(amount = this.amount / other,
              unit = this.unit)

    override fun into(unit: PowerUnit) =
        Power(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}