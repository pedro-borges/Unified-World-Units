package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.unit.derived.termodynamics.WattUnit.WATT

class Watts : Power
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WATT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WATT)

    // region UnitAmount

    override fun plus(power: UnitAmount<PowerUnit>) =
        Watts(this.amount + (power to WATT).amount)

    override fun minus(power: UnitAmount<PowerUnit>) =
        Watts(this.amount - (power to WATT).amount)

    override fun times(scalar: Number) =
        Watts(this.amount * scalar)

    override fun div(scalar: Number) =
        Watts(this.amount / scalar)

    // endregion

    // region composition

    override fun times(time: Time) =
        Joules(amount * (time to SECOND).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Volts(amount / (electricCurrent to AMPERE).amount)

    operator fun div(electricPotential: ElectricPotential) =
        Amperes(amount / (electricPotential to VOLT).amount)

    // endregion
}