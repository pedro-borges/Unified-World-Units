package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.base.WeekUnit

class Weeks : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WeekUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WeekUnit)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Weeks(this.amount + (time to WeekUnit).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Weeks(this.amount - (time to WeekUnit).amount)

    override fun times(scalar: Number) =
        Weeks(this.amount * scalar)

    override fun div(scalar: Number) =
        Weeks(this.amount / scalar)

    // endregion
}