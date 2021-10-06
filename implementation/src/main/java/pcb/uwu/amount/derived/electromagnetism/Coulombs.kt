package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.electromagnetism.CoulombUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.electromagnetism.FaradUnit
import pcb.uwu.unit.derived.electromagnetism.VoltUnit

class Coulombs : ElectricCharge
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CoulombUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CoulombUnit)

    // region UnitAmount

    override fun plus(electricCharge: UnitAmount<ElectricChargeUnit>) =
        Coulombs(this.amount + (electricCharge to CoulombUnit).amount)

    override fun minus(electricCharge: UnitAmount<ElectricChargeUnit>) =
        Coulombs(this.amount - (electricCharge to CoulombUnit).amount)

    override fun times(scalar: Number) =
        Coulombs(this.amount * scalar)

    override fun div(scalar: Number) =
        Coulombs(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(time: Time) =
        Amperes(this.amount / (time to SecondUnit).amount)

    operator fun div(electricCurrent: ElectricCurrent) =
        Seconds(this.amount / (electricCurrent to AmpereUnit).amount)

    override fun div(electricCapacitance: ElectricCapacitance) =
        Volts(this.amount / (electricCapacitance to FaradUnit).amount)

    override fun div(electricPotential: ElectricPotential) =
        Farads(this.amount / (electricPotential to VoltUnit).amount)

    override fun times(electricPotential: ElectricPotential) =
        Joules(this.amount * (electricPotential to VoltUnit).amount)

    // endregion
}
