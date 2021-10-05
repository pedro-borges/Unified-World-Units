package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.InchUnit.INCH
import pcb.uwu.unit.base.LengthUnit

class Inches : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, INCH)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, INCH)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Inches(this.amount + (length to INCH).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Inches(this.amount - (length to INCH).amount)

    override fun times(number: Number) =
        Inches(this.amount * number)

    override fun div(number: Number) =
        Inches(this.amount / number)

    // endregion
}