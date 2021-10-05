package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.electromagnetism.*
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

class Webbers : MagneticFlux
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WebberUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WebberUnit)

    // region UnitAmount

    override fun plus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        Webbers(this.amount + (magneticFlux to WebberUnit).amount)

    override fun minus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        Webbers(this.amount - (magneticFlux to WebberUnit).amount)

    override fun times(scalar: Number) =
        Webbers(this.amount * scalar)

    override fun div(scalar: Number) =
        Webbers(this.amount / scalar)

    override fun to(unit: MagneticFluxUnit) =
        Webbers(getAmountIn(unitAmount = this, newUnit = unit))

    // endregion

    // region composition

    operator fun div(electricPotential: ElectricPotential) =
        Seconds(this.amount / (electricPotential to VoltUnit).amount)

    operator fun div(electricInductance: ElectricInductance) =
        Amperes(this.amount / (electricInductance to HenryUnit).amount)

    override fun div(time: Time) =
        Volts(this.amount / (time to SecondUnit).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Henries(this.amount / (electricCurrent to AmpereUnit).amount)

    override fun div(magneticField: MagneticField) =
        SquareMeters(this.amount / (magneticField to TeslaUnit).amount)

    override fun div(area: Area) =
        Teslas(this.amount / (area to SquareMeterUnit).amount)

    override fun times(electricCurrent: ElectricCurrent) =
        Joules(this.amount * (electricCurrent to AmpereUnit).amount)

    // endregion
}