package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.StoneUnit.STONE

class Stones : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, STONE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, STONE)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Stones(this.amount + (mass to STONE).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Stones(this.amount - (mass to STONE).amount)

    override fun times(scalar: Number) =
        Stones(this.amount * scalar)

    override fun div(scalar: Number) =
        Stones(this.amount / scalar)

    // endregion
}