package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmountOfSubstanceUnit
import pcb.uwu.unit.base.MoleUnit

class Mole : AmountOfSubstance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MoleUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MoleUnit)

    // region UnitAmount

    override fun plus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        Mole(this.amount + (amountOfSubstance to MoleUnit).amount)

    override fun minus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        Mole(this.amount - (amountOfSubstance to MoleUnit).amount)

    override fun times(scalar: Number) =
        Mole(this.amount * scalar)

    override fun div(scalar: Number) =
        Mole(this.amount / scalar)

    // endregion
}
