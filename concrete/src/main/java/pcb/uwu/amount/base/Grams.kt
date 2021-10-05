package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.GramUnit.GRAM
import pcb.uwu.unit.base.MassUnit

class Grams : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, GRAM)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, GRAM)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Grams(this.amount + (mass to GRAM).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Grams(this.amount - (mass to GRAM).amount)

    override fun times(scalar: Number) =
        Grams(this.amount * scalar)

    override fun div(scalar: Number) =
        Grams(this.amount / scalar)

    // endregion
}