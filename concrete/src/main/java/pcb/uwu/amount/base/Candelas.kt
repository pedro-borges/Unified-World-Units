package pcb.uwu.amount.base

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Luminance
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.amount.derived.scalar.SolidAngle
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CandelaUnit.CANDELA
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import pcb.uwu.unit.derived.optics.NitUnit.NIT
import pcb.uwu.unit.scalar.SteradianUnit.STERADIAN

class Candelas : LuminousIntensity
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CANDELA)

    @JvmOverloads
    constructor(amount: String, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CANDELA)

    // region UnitAmount

    override fun plus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        Candelas(this.amount + (luminousIntensity to this.unit).amount)

    override fun minus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        Candelas(this.amount + (luminousIntensity to this.unit).amount)

    override fun times(scalar: Number) =
        Candelas(this.amount * scalar)

    override fun div(scalar: Number) =
        Candelas(this.amount / scalar)

    // endregion

    // region composition

    override fun times(solidAngle: SolidAngle) =
        Lumens(this.amount * (solidAngle to STERADIAN).amount)

    override fun div(area: Area) =
        Nits(this.amount / (area to SQUARE_METER).amount)

    override fun div(luminance: Luminance) =
        SquareMeters(this.amount / (luminance to NIT).amount)

    // endregion
}