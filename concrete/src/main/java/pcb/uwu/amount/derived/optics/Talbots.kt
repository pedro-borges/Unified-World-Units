package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.optics.LumenUnit.LUMEN
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
import pcb.uwu.unit.derived.optics.TalbotUnit.TALBOT

class Talbots : LuminousEnergy
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TALBOT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TALBOT)

    // region UnitAmount

    override fun plus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        Talbots(this.amount + (luminousEnergy to TALBOT).amount)

    override fun minus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        Talbots(this.amount - (luminousEnergy to TALBOT).amount)

    override fun times(scalar: Number) =
        Talbots(this.amount * scalar)

    override fun div(scalar: Number) =
        Talbots(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(luminousFlux: LuminousFlux) =
        Seconds(this.amount / (luminousFlux to LUMEN).amount)

    override fun div(time: Time) =
        Lumens(this.amount / (time to SECOND).amount)

    // endregion
}