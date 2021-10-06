package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.DayUnit
import pcb.uwu.unit.base.TimeUnit

class Days : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, DayUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, DayUnit)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Days(this.amount + (time to DayUnit).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Days(this.amount - (time to DayUnit).amount)

    override fun times(scalar: Number) =
        Days(this.amount * scalar)

    override fun div(scalar: Number) =
        Days(this.amount / scalar)

    // endregion
}
