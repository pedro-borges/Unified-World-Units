package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.NauticalMileUnit.NAUTICAL_MILE

class NauticalMiles : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NAUTICAL_MILE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NAUTICAL_MILE)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        NauticalMiles(this.amount + (length to NAUTICAL_MILE).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        NauticalMiles(this.amount - (length to NAUTICAL_MILE).amount)

    override fun times(scalar: Number) =
        NauticalMiles(this.amount * scalar)

    override fun div(scalar: Number) =
        NauticalMiles(this.amount / scalar)

    // endregion
}