package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.utils.UnitAmountUtils

open class Energy : CompositeUnitAmount<EnergyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: EnergyUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: EnergyUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<EnergyUnit>) =
        Energy(amount = this.amount + (amount to this.unit).amount,
               unit = this.unit)

    override fun minus(amount: UnitAmount<EnergyUnit>) =
        Energy(amount = this.amount - (amount to this.unit).amount,
               unit = this.unit)

    override fun times(number: Number) =
        Energy(amount = this.amount * number,
               unit = this.unit)

    override fun div(number: Number) =
        Energy(amount = this.amount / number,
               unit = this.unit)

    override fun to(unit: EnergyUnit) =
        Energy(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion
}