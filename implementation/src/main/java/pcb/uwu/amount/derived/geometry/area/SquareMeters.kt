package pcb.uwu.amount.derived.geometry.area

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.optics.Illuminance
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Luminance
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import pcb.uwu.unit.derived.optics.LuxUnit
import pcb.uwu.unit.derived.optics.NitUnit

class SquareMeters : Area
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SquareMeterUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SquareMeterUnit)

    // region UnitAmount

    override fun plus(area: UnitAmount<AreaUnit>) =
        SquareMeters(this.amount + (area to SquareMeterUnit).amount)

    override fun minus(area: UnitAmount<AreaUnit>) =
        SquareMeters(this.amount - (area to SquareMeterUnit).amount)

    override fun times(scalar: Number) =
        SquareMeters(this.amount * scalar)

    override fun div(scalar: Number) =
        SquareMeters(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(luminance: Luminance) =
        Candelas(amount * (luminance to NitUnit).amount)

    override fun times(illuminance: Illuminance) =
        Lumens(amount * (illuminance to LuxUnit).amount)

    operator fun div(length: Length) =
        Meters(amount / (length to MeterUnit).amount)

    // endregion

    companion object
    {
        val FOR = SquareMetersFactory()
    }
}
