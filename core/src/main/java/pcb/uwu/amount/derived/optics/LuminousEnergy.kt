package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.utils.UnitAmountUtils

open class LuminousEnergy : CompositeUnitAmount<LuminousEnergyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminousEnergyUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminousEnergyUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        LuminousEnergy(amount = this.amount + (luminousEnergy to this.unit).amount,
                       unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(luminousEnergy: UnitAmount<LuminousEnergyUnit>) =
        LuminousEnergy(amount = this.amount - (luminousEnergy to this.unit).amount,
                       unit = this.unit)

    override fun times(scalar: Number) =
        LuminousEnergy(amount = this.amount * scalar,
                       unit = this.unit)

    override fun div(scalar: Number) =
        LuminousEnergy(amount = this.amount / scalar,
                       unit = this.unit)

    override fun to(unit: LuminousEnergyUnit) =
        LuminousEnergy(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                       unit = unit)

    // endregion

    // region composition

    open operator fun div(time: Time) =
        LuminousFlux(amount = this.amount / time.amount,
                     unit = LuminousFluxUnit(this.unit, time.unit))

    // endregion

}