package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AngleUnit
import pcb.uwu.util.UnitAmountUtils

open class Angle : CompositeUnitAmount<AngleUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AngleUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AngleUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(angle: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount + (angle to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(angle: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount - (angle to this.unit).amount,
              unit = this.unit)

    override fun times(scalar: Number) =
        Angle(amount = this.amount * scalar,
              unit = this.unit)

    override fun div(scalar: Number) =
        Angle(amount = this.amount / scalar,
              unit = this.unit)

    override fun to(unit: AngleUnit) =
        Angle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}