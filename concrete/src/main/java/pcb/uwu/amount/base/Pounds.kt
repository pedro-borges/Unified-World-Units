package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.PoundUnit.POUND

class Pounds : Mass
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, POUND)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, POUND)

    // region UnitAmount

    override fun plus(mass: UnitAmount<MassUnit>) =
        Pounds(this.amount + (mass to POUND).amount)

    override fun minus(mass: UnitAmount<MassUnit>) =
        Pounds(this.amount - (mass to POUND).amount)

    override fun times(number: Number) =
        Pounds(this.amount * number)

    override fun div(number: Number) =
        Pounds(this.amount / number)

    // endregion
}