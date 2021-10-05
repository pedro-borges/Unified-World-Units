package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.YardUnit.YARD

class Yards : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, YARD)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, YARD)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Yards(this.amount + (length to YARD).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Yards(this.amount - (length to YARD).amount)

    override fun times(number: Number) =
        Yards(this.amount * number)

    override fun div(number: Number) =
        Yards(this.amount / number)

    // endregion
}