package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.derived.electromagnetism.CoulombUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.electromagnetism.OhmUnit
import pcb.uwu.unit.derived.electromagnetism.VoltUnit

class Volts : ElectricPotential
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, VoltUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, VoltUnit)

    // region UnitAmount

    override fun plus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        Volts(this.amount + (electricPotential to VoltUnit).amount)

    override fun minus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        Volts(this.amount - (electricPotential to VoltUnit).amount)

    override fun times(scalar: Number) =
        Volts(this.amount * scalar)

    override fun div(scalar: Number) =
        Volts(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(electricResistance: ElectricResistance) =
        Amperes(this.amount / (electricResistance to OhmUnit).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Ohms(this.amount / (electricCurrent to AmpereUnit).amount)

    override fun times(electricCharge: ElectricCharge) =
        Joules(this.amount * (electricCharge to CoulombUnit).amount)

    // endregion
}