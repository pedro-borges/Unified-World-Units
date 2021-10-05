package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.KiloGramUnit
import pcb.uwu.unit.base.MassUnit

class KiloGrams : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, KiloGramUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, KiloGramUnit)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        KiloGrams(this.amount + (mass to KiloGramUnit).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        KiloGrams(this.amount - (mass to KiloGramUnit).amount)

    override fun times(scalar: Number) =
        KiloGrams(this.amount * scalar)

    override fun div(scalar: Number) =
        KiloGrams(this.amount / scalar)

    // endregion
}