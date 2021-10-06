package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.RatioUnit
import pcb.uwu.unit.base.ScalarUnit

class Ratio : Scalar
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RatioUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RatioUnit)

    // region UnitAmount

    override fun plus(scalar: UnitAmount<ScalarUnit>) =
        Ratio(this.amount + (scalar to RatioUnit).amount)

    override fun minus(scalar: UnitAmount<ScalarUnit>) =
        Ratio(this.amount + (scalar to RatioUnit).amount)

    override fun times(scalar: Number) =
        Ratio(this.amount * scalar)

    override fun div(scalar: Number) =
        Ratio(this.amount / scalar)

    // endregion
}
