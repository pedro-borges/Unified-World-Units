package pcb.uwu.amount.base

import pcb.uwu.amount.derived.mechanics.Acceleration
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.util.UnitAmountUtils

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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(mass: UnitAmount<MassUnit>) =
        Mass(amount = this.amount + (mass to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(mass: UnitAmount<MassUnit>) =
        Mass(amount = this.amount - (mass to this.unit).amount,
             unit = this.unit)

    override fun times(scalar: Number) =
        Mass(amount = this.amount * scalar,
             unit = this.unit)

    override fun div(scalar: Number) =
        Mass(amount = this.amount / scalar,
             unit = this.unit)

    override fun to(unit: MassUnit) =
        Mass(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    operator fun times(acceleration: Acceleration) =
        Force(amount = this.amount * acceleration.amount,
              unit = ForceUnit(this.unit, acceleration.unit))

    // endregion
}
