package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.electromagnetism.VoltUnit
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.unit.derived.termodynamics.WattUnit

class Watts : Power
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WattUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WattUnit)

    // region UnitAmount

    override fun plus(power: UnitAmount<PowerUnit>) =
        Watts(this.amount + (power to WattUnit).amount)

    override fun minus(power: UnitAmount<PowerUnit>) =
        Watts(this.amount - (power to WattUnit).amount)

    override fun times(scalar: Number) =
        Watts(this.amount * scalar)

    override fun div(scalar: Number) =
        Watts(this.amount / scalar)

    // endregion

    // region composition

    override fun times(time: Time) =
        Joules(this.amount * (time to SecondUnit).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Volts(this.amount / (electricCurrent to AmpereUnit).amount)

    operator fun div(electricPotential: ElectricPotential) =
        Amperes(this.amount / (electricPotential to VoltUnit).amount)

    // endregion
}
