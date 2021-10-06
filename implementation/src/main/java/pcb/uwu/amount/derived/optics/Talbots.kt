package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.optics.LumenUnit
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
import pcb.uwu.unit.derived.optics.TalbotUnit

class Talbots : LuminousEnergy
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TalbotUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TalbotUnit)

    // region UnitAmount

    override fun plus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        Talbots(this.amount + (luminousEnergy to TalbotUnit).amount)

    override fun minus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        Talbots(this.amount - (luminousEnergy to TalbotUnit).amount)

    override fun times(scalar: Number) =
        Talbots(this.amount * scalar)

    override fun div(scalar: Number) =
        Talbots(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(luminousFlux: LuminousFlux) =
        Seconds(this.amount / (luminousFlux to LumenUnit).amount)

    override fun div(time: Time) =
        Lumens(this.amount / (time to SecondUnit).amount)

    // endregion
}
