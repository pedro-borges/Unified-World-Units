package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.LuminousIntensity
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.scalar.SolidAngle
import pcb.uwu.amount.derived.scalar.Steradians
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.optics.LumenUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.unit.derived.optics.LuxUnit
import pcb.uwu.unit.scalar.SteradianUnit

class Lumens : LuminousFlux
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LumenUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LumenUnit)

    // region UnitAmount

    override fun plus(luminousFlux: UnitAmount<LuminousFluxUnit>) =
        Lumens(this.amount + (luminousFlux to LumenUnit).amount)

    override fun minus(luminousFlux: UnitAmount<LuminousFluxUnit>) =
        Lumens(this.amount - (luminousFlux to LumenUnit).amount)

    override fun times(scalar: Number) =
        Lumens(this.amount * scalar)

    override fun div(scalar: Number) =
        Lumens(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(solidAngle: SolidAngle) =
        Candelas(this.amount / (solidAngle to SteradianUnit).amount)

    override fun div(luminousIntensity: LuminousIntensity) =
        Steradians(this.amount / (luminousIntensity to CandelaUnit).amount)

    override fun times(time: Time) =
        Talbots(this.amount * (time to SecondUnit).amount)

    override fun div(area: Area) =
        Lux(this.amount / (area to SquareMeterUnit).amount)

    override fun div(illuminance: Illuminance) =
        SquareMeters(this.amount / (illuminance to LuxUnit).amount)

    // endregion
}