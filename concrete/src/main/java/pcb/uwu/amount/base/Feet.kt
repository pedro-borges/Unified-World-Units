package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.FootUnit.FOOT
import pcb.uwu.unit.base.LengthUnit

class Feet : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FOOT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FOOT)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Feet(this.amount + (length to FOOT).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Feet(this.amount - (length to FOOT).amount)

    override fun times(scalar: Number) =
        Feet(this.amount * scalar)

    override fun div(scalar: Number) =
        Feet(this.amount / scalar)

    // endregion
}