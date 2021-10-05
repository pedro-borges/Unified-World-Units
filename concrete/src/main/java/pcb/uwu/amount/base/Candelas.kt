package pcb.uwu.amount.base

import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Luminance
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.amount.derived.scalar.SolidAngle
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import pcb.uwu.unit.derived.geometry.SteradianUnit
import pcb.uwu.unit.derived.optics.NitUnit

class Candelas : LuminousIntensity
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CandelaUnit)

    @JvmOverloads
    constructor(amount: String, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CandelaUnit)

    // region UnitAmount

    override fun plus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        Candelas(this.amount + (luminousIntensity to CandelaUnit).amount)

    override fun minus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        Candelas(this.amount + (luminousIntensity to CandelaUnit).amount)

    override fun times(scalar: Number) =
        Candelas(this.amount * scalar)

    override fun div(scalar: Number) =
        Candelas(this.amount / scalar)

    // endregion

    // region composition

    override fun times(solidAngle: SolidAngle) =
        Lumens(this.amount * (solidAngle to SteradianUnit).amount)

    override fun div(area: Area) =
        Nits(this.amount / (area to SquareMeterUnit).amount)

    override fun div(luminance: Luminance) =
        SquareMeters(this.amount / (luminance to NitUnit).amount)

    // endregion
}