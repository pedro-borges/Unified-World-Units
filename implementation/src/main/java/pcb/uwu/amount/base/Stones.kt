package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.StoneUnit

class Stones : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, StoneUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, StoneUnit)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Stones(this.amount + (mass to StoneUnit).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Stones(this.amount - (mass to StoneUnit).amount)

    override fun times(scalar: Number) =
        Stones(this.amount * scalar)

    override fun div(scalar: Number) =
        Stones(this.amount / scalar)

    // endregion
}