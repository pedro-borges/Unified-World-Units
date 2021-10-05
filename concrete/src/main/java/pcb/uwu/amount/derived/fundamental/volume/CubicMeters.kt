package pcb.uwu.amount.derived.fundamental.volume

import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.core.Magnitude
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit
import pcb.uwu.unit.derived.fundamental.LitreUnit
import pcb.uwu.unit.derived.fundamental.VolumeUnit

class CubicMeters : Volume
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = Magnitude.NATURAL)
            : super(amount, magnitude, CubicMeterUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = Magnitude.NATURAL)
            : super(amount, magnitude, CubicMeterUnit)

    // region UnitAmount

    override fun plus(volume: UnitAmount<VolumeUnit>) =
        Litres(this.amount + (volume to LitreUnit).amount)

    override fun minus(volume: UnitAmount<VolumeUnit>) =
        Litres(this.amount - (volume to LitreUnit).amount)

    override fun times(scalar: Number) =
        Litres(this.amount * scalar)

    override fun div(scalar: Number) =
        Litres(this.amount / scalar)

    // endregion
}
