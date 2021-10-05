package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AngleUnit
import pcb.uwu.unit.base.RadianUnit.RADIAN

class Radians : Angle
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RADIAN)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RADIAN)

    // region UnitAmount

    override fun plus(angle: UnitAmount<AngleUnit>) =
        Radians(this.amount + (angle to RADIAN).amount)

    override fun minus(angle: UnitAmount<AngleUnit>) =
        Radians(this.amount - (angle to RADIAN).amount)

    override fun times(scalar: Number) =
        Radians(this.amount * scalar)

    override fun div(scalar: Number) =
        Radians(this.amount / scalar)

    // endregion
}