package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.PoundUnit

class Pounds : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PoundUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PoundUnit)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Pounds(this.amount + (mass to PoundUnit).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Pounds(this.amount - (mass to PoundUnit).amount)

    override fun times(scalar: Number) =
        Pounds(this.amount * scalar)

    override fun div(scalar: Number) =
        Pounds(this.amount / scalar)

    // endregion
}