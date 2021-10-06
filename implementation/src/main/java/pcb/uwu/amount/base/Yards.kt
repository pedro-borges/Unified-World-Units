package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.YardUnit

class Yards : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, YardUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, YardUnit)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Yards(this.amount + (length to YardUnit).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Yards(this.amount - (length to YardUnit).amount)

    override fun times(scalar: Number) =
        Yards(this.amount * scalar)

    override fun div(scalar: Number) =
        Yards(this.amount / scalar)

    // endregion
}
