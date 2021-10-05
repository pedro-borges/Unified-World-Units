package pcb.uwu.amount.derived.fundamental.area

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.optics.Illuminance
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Luminance
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.derived.optics.LuxUnit
import pcb.uwu.unit.derived.optics.NitUnit.NIT

class SquareMeters : Area
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SQUARE_METER)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SQUARE_METER)

    // region UnitAmount

    override fun plus(area: UnitAmount<AreaUnit>) =
        SquareMeters(this.amount + (area to SQUARE_METER).amount)

    override fun minus(area: UnitAmount<AreaUnit>) =
        SquareMeters(this.amount - (area to SQUARE_METER).amount)

    override fun times(scalar: Number) =
        SquareMeters(this.amount * scalar)

    override fun div(scalar: Number) =
        SquareMeters(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(luminance: Luminance) =
        Candelas(amount * (luminance to NIT).amount)

    override fun times(illuminance: Illuminance) =
        Lumens(amount * (illuminance to LuxUnit.LUX).amount)

    operator fun div(length: Length) =
        Meters(amount / (length to METER).amount)

    // endregion

    companion object
    {
        val FOR = SquareMetersFactory()
    }
}