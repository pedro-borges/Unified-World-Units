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
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import pcb.uwu.unit.derived.electromagnetism.HenryUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.unit.derived.electromagnetism.TeslaUnit.TESLA
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT
import pcb.uwu.unit.derived.electromagnetism.WebberUnit.WEBBER
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

class Webbers : MagneticFlux
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WEBBER)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, WEBBER)

    // region UnitAmount

    override fun plus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        Webbers(this.amount + (magneticFlux to WEBBER).amount)

    override fun minus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        Webbers(this.amount - (magneticFlux to WEBBER).amount)

    override fun times(scalar: Number) =
        Webbers(this.amount * scalar)

    override fun div(scalar: Number) =
        Webbers(this.amount / scalar)

    override fun to(unit: MagneticFluxUnit) =
        Webbers(getAmountIn(unitAmount = this, newUnit = unit))

    // endregion

    // region composition

    operator fun div(electricPotential: ElectricPotential) =
        Seconds(this.amount / (electricPotential to VOLT).amount)

    operator fun div(electricInductance: ElectricInductance) =
        Amperes(this.amount / (electricInductance to HenryUnit.HENRY).amount)

    override fun div(time: Time) =
        Volts(this.amount / (time to SECOND).amount)

    override fun div(electricCurrent: ElectricCurrent) =
        Henries(this.amount / (electricCurrent to AMPERE).amount)

    override fun div(magneticField: MagneticField) =
        SquareMeters(this.amount / (magneticField to TESLA).amount)

    override fun div(area: Area) =
        Teslas(this.amount / (area to SQUARE_METER).amount)

    override fun times(electricCurrent: ElectricCurrent) =
        Joules(this.amount * (electricCurrent to AMPERE).amount)

    // endregion
}