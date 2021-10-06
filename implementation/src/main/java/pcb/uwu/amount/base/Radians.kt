package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AngleUnit
import pcb.uwu.unit.base.RadianUnit

class Radians : Angle
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RadianUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, RadianUnit)

    // region UnitAmount

    override fun plus(angle: UnitAmount<AngleUnit>) =
        Radians(this.amount + (angle to RadianUnit).amount)

    override fun minus(angle: UnitAmount<AngleUnit>) =
        Radians(this.amount - (angle to RadianUnit).amount)

    override fun times(scalar: Number) =
        Radians(this.amount * scalar)

    override fun div(scalar: Number) =
        Radians(this.amount / scalar)

    // endregion
}
