package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MileUnit

class Miles : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MileUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MileUnit)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Miles(this.amount + (length to MileUnit).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Miles(this.amount + (length to MileUnit).amount)

    override fun times(scalar: Number) =
        Miles(this.amount * scalar)

    override fun div(scalar: Number) =
        Miles(this.amount / scalar)

    // endregion
}