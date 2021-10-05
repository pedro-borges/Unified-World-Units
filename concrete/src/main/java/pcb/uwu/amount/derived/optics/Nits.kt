package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import pcb.uwu.unit.derived.optics.LuminanceUnit
import pcb.uwu.unit.derived.optics.NitUnit.NIT

class Nits : Luminance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NIT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NIT)

    // region UnitAmount

    override fun plus(luminance: UnitAmount<LuminanceUnit>) =
        Nits(this.amount + (luminance to NIT).amount)

    override fun minus(luminance: UnitAmount<LuminanceUnit>) =
        Nits(this.amount - (luminance to NIT).amount)

    override fun times(scalar: Number) =
        Nits(this.amount * scalar)

    override fun div(scalar: Number) =
        Nits(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(area: Area): Candelas
    {
        return Candelas(amount * (area to SQUARE_METER).amount)
    }

    // endregion
}