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
    constructor(value: String,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, DAY)

    // region UnitAmount

    override fun plus(amount: UnitAmount<TimeUnit>) =
        Days(this.amount + (amount to DAY).amount)

    override fun minus(amount: UnitAmount<TimeUnit>) =
        Days(this.amount - (amount to DAY).amount)

    override fun times(number: Number) =
        Days(this.amount * number)

    override fun div(number: Number) =
        Days(this.amount / number)

    // endregion
}