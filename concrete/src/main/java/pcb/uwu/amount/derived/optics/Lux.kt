package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.optics.IlluminanceUnit
import pcb.uwu.unit.derived.optics.LuxUnit

class Lux : Illuminance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LuxUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LuxUnit)

    // region UnitAmount

    override fun plus(illuminance: UnitAmount<IlluminanceUnit>) =
        Lux(this.amount + (illuminance to LuxUnit).amount)

    override fun minus(illuminance: UnitAmount<IlluminanceUnit>) =
        Lux(this.amount - (illuminance to LuxUnit).amount)

    override fun times(scalar: Number) =
        Lux(this.amount * scalar)

    override fun div(scalar: Number) =
        Lux(this.amount / scalar)

    // endregion

    // region composition

    override fun times(area: Area) =
        Lumens(amount * (area to SquareMeterUnit).amount)

    // endregion
}