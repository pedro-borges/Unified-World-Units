package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT

class Volts : ElectricPotential
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, VOLT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, VOLT)

    // region UnitAmount

    override fun plus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        Volts(this.amount + (electricPotential to VOLT).amount)

    override fun minus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        Volts(this.amount - (electricPotential to VOLT).amount)

    override fun times(scalar: Number) =
        Volts(this.amount * scalar)

    override fun div(scalar: Number) =
        Volts(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(electricResistance: ElectricResistance) =
        Amperes(this.amount / (electricResistance to OHM).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Ohms(this.amount / (electricCurrent to AMPERE).amount)

    override fun times(electricCharge: ElectricCharge) =
        Joules(this.amount * (electricCharge to COULOMB).amount)

    // endregion
}