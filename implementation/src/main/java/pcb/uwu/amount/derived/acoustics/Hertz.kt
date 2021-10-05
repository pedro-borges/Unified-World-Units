package pcb.uwu.amount.derived.acoustics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.acoustics.FrequencyUnit
import pcb.uwu.unit.derived.acoustics.HertzUnit

class Hertz : Frequency
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HertzUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HertzUnit)

    // region UnitAmount

    override fun plus(frequency: UnitAmount<FrequencyUnit>) =
        Hertz(this.amount + (frequency to HertzUnit).amount)

    override fun minus(frequency: UnitAmount<FrequencyUnit>) =
        Hertz(this.amount - (frequency to HertzUnit).amount)

    override fun times(scalar: Number) =
        Hertz(this.amount * scalar)

    override fun div(scalar: Number) =
        Hertz(this.amount / scalar)

    // endregion
}