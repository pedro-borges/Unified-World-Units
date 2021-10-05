package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.amount.derived.optics.Talbots
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.amount.derived.thermodynamics.Power
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.optics.LumenUnit
import pcb.uwu.unit.derived.termodynamics.WattUnit

class Seconds : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SecondUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SecondUnit)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Seconds(this.amount + (time to SecondUnit).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Seconds(this.amount - (time to SecondUnit).amount)

    override fun times(scalar: Number) =
        Seconds(this.amount * scalar)

    override fun div(scalar: Number) =
        Seconds(this.amount / scalar)

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent) =
        Coulombs(this.amount * (electricCurrent to AmpereUnit).amount)

    override fun times(power: Power) =
        Joules(this.amount * (power to WattUnit).amount)

    override fun times(luminousFlux: LuminousFlux) =
        Talbots(this.amount * (luminousFlux to LumenUnit).amount)

    // endregion
}