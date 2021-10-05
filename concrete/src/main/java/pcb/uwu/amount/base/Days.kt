package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.DayUnit.DAY
import pcb.uwu.unit.base.TimeUnit

class Days : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, DAY)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, DAY)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Days(this.amount + (time to DAY).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Days(this.amount - (time to DAY).amount)

    override fun times(number: Number) =
        Days(this.amount * number)

    override fun div(number: Number) =
        Days(this.amount / number)

    // endregion
}