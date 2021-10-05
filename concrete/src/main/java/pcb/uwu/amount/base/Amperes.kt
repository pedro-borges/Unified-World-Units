package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.*
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.electromagnetism.*

class Amperes : ElectricCurrent
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AmpereUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AmpereUnit)

    // region UnitAmount

    override fun plus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        Amperes(this.amount + (electricCurrrent to AmpereUnit).amount)

    override fun minus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        Amperes(this.amount - (electricCurrrent to AmpereUnit).amount)

    override fun times(scalar: Number) =
        Amperes(this.amount * scalar)

    override fun div(scalar: Number) =
        Amperes(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(time: Time) =
        Coulombs(this.amount * (time to SecondUnit).amount)

    operator fun times(electricResistance: ElectricResistance) =
        Volts(this.amount * (electricResistance to OhmUnit).amount)

    operator fun times(electricInductance: ElectricInductance) =
        Webbers(this.amount * (electricInductance to HenryUnit).amount)

    operator fun times(magneticFlux: MagneticFlux) =
        Joules(this.amount * (magneticFlux to WebberUnit).amount)

    operator fun div(electricPotential: ElectricPotential): Siemens
    {
        return Siemens(this.amount / (electricPotential to VoltUnit).amount)
    }

    operator fun div(electricConductance: ElectricConductance): Volts
    {
        return Volts(this.amount / (electricConductance to SiemensUnit).amount)
    }

    // endregion
}