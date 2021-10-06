package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.InchUnit
import pcb.uwu.unit.base.LengthUnit

class Inches : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, InchUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, InchUnit)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Inches(this.amount + (length to InchUnit).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Inches(this.amount - (length to InchUnit).amount)

    override fun times(scalar: Number) =
        Inches(this.amount * scalar)

    override fun div(scalar: Number) =
        Inches(this.amount / scalar)

    // endregion
}
