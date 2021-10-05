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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(power: UnitAmount<PowerUnit>) =
        Power(amount = this.amount + (power to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(power: UnitAmount<PowerUnit>) =
        Power(amount = this.amount - (power to this.unit).amount,
              unit = this.unit)

    override fun times(number: Number) =
        Power(amount = this.amount * number,
              unit = this.unit)

    override fun div(number: Number) =
        Power(amount = this.amount / number,
              unit = this.unit)

    override fun to(unit: PowerUnit) =
        Power(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}