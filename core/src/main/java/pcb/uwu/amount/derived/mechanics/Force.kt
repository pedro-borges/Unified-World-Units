package pcb.uwu.amount.derived.mechanics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.utils.UnitAmountUtils

open class Force : CompositeUnitAmount<ForceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ForceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ForceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(force: UnitAmount<ForceUnit>) =
        Force(amount = this.amount + (force to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(force: UnitAmount<ForceUnit>) =
        Force(amount = this.amount - (force to this.unit).amount,
              unit = this.unit)

    override fun times(number: Number) =
        Force(amount = this.amount * number,
              unit = this.unit)

    override fun div(number: Number) =
        Force(amount = this.amount / number,
              unit = this.unit)

    override fun to(unit: ForceUnit) =
        Force(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}