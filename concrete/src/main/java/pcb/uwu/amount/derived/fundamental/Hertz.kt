package pcb.uwu.amount.derived.fundamental

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.unit.derived.fundamental.HertzUnit.HERTZ

class Hertz : Frequency
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HERTZ)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HERTZ)

    // region UnitAmount

    override fun plus(frequency: UnitAmount<FrequencyUnit>) =
        Hertz(this.amount + (frequency to HERTZ).amount)

    override fun minus(frequency: UnitAmount<FrequencyUnit>) =
        Hertz(this.amount - (frequency to HERTZ).amount)

    override fun times(scalar: Number) =
        Hertz(this.amount * scalar)

    override fun div(scalar: Number) =
        Hertz(this.amount / scalar)

    // endregion
}