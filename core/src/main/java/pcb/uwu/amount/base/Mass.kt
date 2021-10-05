package pcb.uwu.amount.base

import pcb.uwu.amount.derived.mechanics.Acceleration
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.utils.UnitAmountUtils

open class Mass : CompositeUnitAmount<MassUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<MassUnit>) =
        Mass(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<MassUnit>) =
        Mass(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override operator fun times(other: Number) =
        Mass(amount = this.amount * other,
             unit = this.unit)

    override operator fun div(other: Number) =
        Mass(amount = this.amount / other,
             unit = this.unit)

    override fun into(unit: MassUnit) =
        Mass(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    operator fun times(acceleration: Acceleration) =
        Force(amount = this.amount * acceleration.amount,
              unit = ForceUnit(this.unit, acceleration.unit))

    // endregion
}