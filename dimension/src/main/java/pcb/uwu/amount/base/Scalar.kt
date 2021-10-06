package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.ScalarUnit
import pcb.uwu.util.UnitAmountUtils

open class Scalar : CompositeUnitAmount<ScalarUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ScalarUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ScalarUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(scalar: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount + (scalar to this.unit).amount,
               unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(scalar: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount - (scalar to this.unit).amount,
               unit = this.unit)


    override fun times(scalar: Number) =
        Scalar(amount = this.amount * scalar,
               unit = this.unit)

    override fun div(scalar: Number) =
        Scalar(amount = this.amount / scalar,
               unit = this.unit)

    override fun to(unit: ScalarUnit) =
        Scalar(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
               unit = this.unit)

    // endregion
}
