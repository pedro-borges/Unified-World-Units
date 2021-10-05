package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.*
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY
import pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM
import pcb.uwu.unit.derived.electromagnetism.SiemensUnit.SIEMENS
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT
import pcb.uwu.unit.derived.electromagnetism.WebberUnit.WEBBER

class Amperes : ElectricCurrent
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AMPERE)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AMPERE)

    // region UnitAmount

    override fun plus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        Amperes(this.amount + (electricCurrrent to AMPERE).amount)

    override fun minus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        Amperes(this.amount - (electricCurrrent to AMPERE).amount)

    override fun times(scalar: Number) =
        Amperes(this.amount * scalar)

    override fun div(scalar: Number) =
        Amperes(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(time: Time) =
        Coulombs(this.amount * (time to SECOND).amount)

    operator fun times(electricResistance: ElectricResistance) =
        Volts(this.amount * (electricResistance to OHM).amount)

    operator fun times(electricInductance: ElectricInductance) =
        Webbers(this.amount * (electricInductance to HENRY).amount)

    operator fun times(magneticFlux: MagneticFlux) =
        Joules(this.amount * (magneticFlux to WEBBER).amount)

    operator fun div(electricPotential: ElectricPotential): Siemens
    {
        return Siemens(this.amount / (electricPotential to VOLT).amount)
    }

    operator fun div(electricConductance: ElectricConductance): Volts
    {
        return Volts(this.amount / (electricConductance to SIEMENS).amount)
    }

    // endregion
}