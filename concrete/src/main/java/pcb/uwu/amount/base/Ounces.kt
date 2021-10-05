package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.OunceUnit.OUNCE

class Ounces : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, OUNCE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, OUNCE)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Ounces(this.amount + (mass to OUNCE).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Ounces(this.amount - (mass to OUNCE).amount)

    override fun times(scalar: Number) =
        Ounces(this.amount * scalar)

    override fun div(scalar: Number) =
        Ounces(this.amount / scalar)

    // endregion
}