package pcb.uwu.amount.base

import pcb.uwu.amount.derived.acoustics.Frequency
import pcb.uwu.amount.derived.economics.Currency
import pcb.uwu.amount.derived.economics.Debt
import pcb.uwu.amount.derived.electromagnetism.ElectricCharge
import pcb.uwu.amount.derived.mechanics.Pace
import pcb.uwu.amount.derived.optics.LuminousEnergy
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.amount.derived.thermodynamics.Power
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.acoustics.FrequencyUnit
import pcb.uwu.unit.derived.economics.DebtUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.mechanics.PaceUnit
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.util.UnitAmountUtils

open class Time : CompositeUnitAmount<TimeUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(time: UnitAmount<TimeUnit>) =
        Time(amount = this.amount + (time to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(time: UnitAmount<TimeUnit>) =
        Time(amount = this.amount - (time to this.unit).amount,
             unit = this.unit)

    override fun times(scalar: Number) =
        Time(amount = this.amount * scalar,
             unit = this.unit)

    override fun div(scalar: Number) =
        Time(amount = this.amount / scalar,
             unit = this.unit)

    override fun to(unit: TimeUnit) =
        Time(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    override fun invert() =
        Frequency(amount = amount.invert(),
                  unit = FrequencyUnit(unit))

    // endregion

    // region composition

    open operator fun times(currency: Currency) =
        Debt(amount = this.amount * currency.amount,
             unit = DebtUnit(currencyUnit = currency.unit,
                             timeUnit = this.unit))

    open operator fun div(length: Length) =
        Pace(amount = this.amount / length.amount,
             unit = PaceUnit(timeUnit = this.unit,
                             lengthUnit = length.unit))


    open operator fun times(electricCurrent: ElectricCurrent) =
        ElectricCharge(amount = this.amount * electricCurrent.amount,
                       unit = ElectricChargeUnit(electricCurrentUnit = electricCurrent.unit,
                                                 timeUnit = this.unit))

    open operator fun times(power: Power) =
        Energy(amount = this.amount * power.amount,
               unit = EnergyUnit(powerUnit = power.unit, timeUnit = this.unit))

    open operator fun times(luminousFlux: LuminousFlux) =
        LuminousEnergy(amount = this.amount * luminousFlux.amount,
                       unit = LuminousEnergyUnit(luminousFluxUnit = luminousFlux.unit,
                                                 timeUnit = this.unit))

    // endregion
}
