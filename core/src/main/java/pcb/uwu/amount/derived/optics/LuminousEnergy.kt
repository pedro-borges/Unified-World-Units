package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
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

    override fun plus(amount: UnitAmount<LuminousEnergyUnit>) =
        LuminousEnergy(amount = this.amount + (amount to this.unit).amount,
                       unit = this.unit)

    override fun minus(amount: UnitAmount<LuminousEnergyUnit>) =
        LuminousEnergy(amount = this.amount - (amount to this.unit).amount,
                       unit = this.unit)

    override fun times(number: Number) =
        LuminousEnergy(amount = this.amount * number,
                       unit = this.unit)

    override fun div(number: Number) =
        LuminousEnergy(amount = this.amount / number,
                       unit = this.unit)

    override fun to(unit: LuminousEnergyUnit) =
        LuminousEnergy(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                       unit = unit)

    // endregion
}