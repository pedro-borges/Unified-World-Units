package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MinuteUnit.MINUTE
import pcb.uwu.unit.base.TimeUnit

class Minutes : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MINUTE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MINUTE)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>): Minutes =
        Minutes(this.amount + (time to MINUTE).amount)

    override fun minus(time: UnitAmount<TimeUnit>): Minutes =
        Minutes(this.amount + (time to MINUTE).amount)


    override fun times(number: Number): Minutes =
        Minutes(this.amount * number)

    override fun div(number: Number): Minutes =
        Minutes(this.amount / number)

    // endregion
}