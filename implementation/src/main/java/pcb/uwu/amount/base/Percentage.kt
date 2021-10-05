package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.PercentageUnit
import pcb.uwu.unit.base.ScalarUnit

class Percentage : Scalar
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PercentageUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PercentageUnit)

    // region UnitAmount

    override fun plus(scalar: UnitAmount<ScalarUnit>) =
        Percentage(this.amount + (scalar to PercentageUnit).amount)

    override fun minus(scalar: UnitAmount<ScalarUnit>) =
        Percentage(this.amount + (scalar to PercentageUnit).amount)

    override fun times(scalar: Number) =
        Percentage(this.amount * scalar)

    override fun div(scalar: Number) =
        Percentage(this.amount / scalar)

    // endregion
}