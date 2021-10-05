package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.HourUnit.HOUR
import pcb.uwu.unit.base.TimeUnit

class Hours : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HOUR)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HOUR)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Hours(this.amount + (time to HOUR).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Hours(this.amount - (time to HOUR).amount)

    override fun times(number: Number) =
        Hours(this.amount * number)

    override fun div(number: Number) =
        Hours(this.amount / number)

    // endregion
}