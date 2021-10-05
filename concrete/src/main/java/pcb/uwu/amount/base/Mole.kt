package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmountOfSubstanceUnit
import pcb.uwu.unit.base.MoleUnit.MOLE

class Mole : AmountOfSubstance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MOLE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MOLE)

    // region UnitAmount

    override fun plus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        Mole(this.amount + (amountOfSubstance to MOLE).amount)


    override fun minus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        Mole(this.amount - (amountOfSubstance to MOLE).amount)

    override fun times(number: Number) =
        Mole(this.amount * number)

    override fun div(number: Number) =
        Mole(this.amount / number)

    // endregion
}