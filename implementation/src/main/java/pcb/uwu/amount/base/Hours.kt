package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.HourUnit
import pcb.uwu.unit.base.TimeUnit

class Hours : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HourUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HourUnit)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Hours(this.amount + (time to HourUnit).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Hours(this.amount - (time to HourUnit).amount)

    override fun times(scalar: Number) =
        Hours(this.amount * scalar)

    override fun div(scalar: Number) =
        Hours(this.amount / scalar)

    // endregion
}
