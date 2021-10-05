package pcb.uwu.amount.derived.fundamental.volume

import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE
import pcb.uwu.unit.derived.fundamental.VolumeUnit

class Litres : Volume
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LITRE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, LITRE)

    // region UnitAmount

    override fun plus(volume: UnitAmount<VolumeUnit>) =
        Litres(this.amount + (volume to LITRE).amount)

    override fun minus(volume: UnitAmount<VolumeUnit>) =
        Litres(this.amount - (volume to LITRE).amount)

    override fun times(scalar: Number) =
        Litres(this.amount * scalar)

    override fun div(scalar: Number) =
        Litres(this.amount / scalar)

    // endregion

    companion object
    {
        val FOR = LitresFactory()
    }
}