package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.electromagnetism.ElectricCharge
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.amount.derived.geometry.Volume
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.amount.derived.mechanics.Newtons
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.electromagnetism.CoulombUnit
import pcb.uwu.unit.derived.electromagnetism.VoltUnit
import pcb.uwu.unit.derived.geometry.CubicMeterUnit
import pcb.uwu.unit.derived.mechanics.NewtonUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.JouleUnit
import pcb.uwu.unit.derived.termodynamics.PascalUnit
import pcb.uwu.unit.derived.termodynamics.WattUnit

class Joules : Energy
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JouleUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JouleUnit)

    // region UnitAmount

    override fun plus(energy: UnitAmount<EnergyUnit>) =
        Joules(this.amount + (energy to JouleUnit).amount)

    override fun minus(energy: UnitAmount<EnergyUnit>) =
        Joules(this.amount - (energy to JouleUnit).amount)

    override fun times(scalar: Number) =
        Joules(this.amount * scalar)

    override fun div(scalar: Number) =
        Joules(this.amount / scalar)

    // endregion

    // region composition

    override fun div(volume: Volume) =
        Pascals(this.amount / (volume to CubicMeterUnit).amount)

    override fun div(pressure: Pressure) =
        Volume(amount = this.amount / (pressure to PascalUnit).amount,
               unit = CubicMeterUnit)

    operator fun div(power: Power) =
        Seconds(this.amount / (power to WattUnit).amount)

    override fun div(time: Time) =
        Watts(this.amount / (time to SecondUnit).amount)

    override fun div(length: Length) =
        Newtons(this.amount / (length to MeterUnit).amount)

    operator fun div(force: Force) =
        Meters(this.amount / (force to NewtonUnit).amount)

    override fun div(electricCharge: ElectricCharge) =
        Volts(this.amount / (electricCharge to CoulombUnit).amount)

    override fun div(electricPotential: ElectricPotential) =
        Coulombs(this.amount / (electricPotential to VoltUnit).amount)

    // endregion
}
