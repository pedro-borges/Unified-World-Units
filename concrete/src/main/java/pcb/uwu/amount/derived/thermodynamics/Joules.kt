package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.electromagnetism.ElectricCharge
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.amount.derived.mechanics.Newtons
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER
import pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.JouleUnit.JOULE
import pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL
import pcb.uwu.unit.derived.termodynamics.WattUnit

class Joules : Energy
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JOULE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JOULE)

    // region UnitAmount

    override fun plus(energy: UnitAmount<EnergyUnit>) =
        Joules(this.amount + (energy to JOULE).amount)

    override fun minus(energy: UnitAmount<EnergyUnit>) =
        Joules(this.amount - (energy to JOULE).amount)

    override fun times(scalar: Number) =
        Joules(this.amount * scalar)

    override fun div(scalar: Number) =
        Joules(this.amount / scalar)

    // endregion

    // region composition

    override fun div(volume: Volume) =
        Pascals(this.amount / (volume to CUBIC_METER).amount)

    override fun div(pressure: Pressure) =
        Volume(amount = this.amount / (pressure to PASCAL).amount,
                      unit = CUBIC_METER)

    operator fun div(power: Power) =
        Seconds(this.amount / (power to WattUnit.WATT).amount)

    override fun div(time: Time) =
        Watts(this.amount / (time to SECOND).amount)

    override fun div(length: Length) =
        Newtons(this.amount / (length to METER).amount)

    operator fun div(force: Force) =
        Meters(this.amount / (force to NEWTON).amount)

    override fun div(electricCharge: ElectricCharge) =
        Volts(this.amount / (electricCharge to COULOMB).amount)

    override fun div(electricPotential: ElectricPotential) =
        Coulombs(this.amount / (electricPotential to VOLT).amount)

    // endregion
}