package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.base.WeekUnit.WEEK

class Weeks : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WEEK)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WEEK)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Weeks(this.amount + (time to WEEK).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Weeks(this.amount - (time to WEEK).amount)

    override fun times(number: Number) =
        Weeks(this.amount * number)

    override fun div(number: Number) =
        Weeks(this.amount / number)

    // endregion
}