package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import pcb.uwu.unit.derived.optics.LuminanceUnit
import pcb.uwu.unit.derived.optics.NitUnit

class Nits : Luminance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NitUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NitUnit)

    // region UnitAmount

    override fun plus(luminance: UnitAmount<LuminanceUnit>) =
        Nits(this.amount + (luminance to NitUnit).amount)

    override fun minus(luminance: UnitAmount<LuminanceUnit>) =
        Nits(this.amount - (luminance to NitUnit).amount)

    override fun times(scalar: Number) =
        Nits(this.amount * scalar)

    override fun div(scalar: Number) =
        Nits(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(area: Area): Candelas
    {
        return Candelas(amount * (area to SquareMeterUnit).amount)
    }

    // endregion
}