package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.amount.derived.optics.Talbots
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.amount.derived.thermodynamics.Power
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.optics.LumenUnit.LUMEN
import pcb.uwu.unit.derived.termodynamics.WattUnit.WATT

class Seconds : Time
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SECOND)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SECOND)

    // region UnitAmount

    override fun plus(time: UnitAmount<TimeUnit>) =
        Seconds(this.amount + (time to SECOND).amount)

    override fun minus(time: UnitAmount<TimeUnit>) =
        Seconds(this.amount - (time to SECOND).amount)

    override fun times(number: Number) =
        Seconds(this.amount * number)

    override fun div(number: Number) =
        Seconds(this.amount / number)

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent) =
        Coulombs(amount * (electricCurrent to  AMPERE).amount)

    override fun times(power: Power) =
        Joules(amount * (power to WATT).amount)

    override fun times(luminousFlux: LuminousFlux) =
        Talbots(amount * (luminousFlux to LUMEN).amount)

    // endregion
}