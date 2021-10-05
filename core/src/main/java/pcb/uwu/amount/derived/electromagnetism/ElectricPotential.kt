package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricPotential : CompositeUnitAmount<ElectricPotentialUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricPotentialUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricPotentialUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<ElectricPotentialUnit>) =
        ElectricPotential(amount = this.amount + (amount to this.unit).amount,
                          unit = this.unit)

    override fun minus(amount: UnitAmount<ElectricPotentialUnit>) =
        ElectricPotential(amount = this.amount - (amount to this.unit).amount,
                          unit = this.unit)

    override fun times(number: Number): ElectricPotential =
        ElectricPotential(amount = this.amount * number,
                          unit = this.unit)

    override fun div(number: Number) =
        ElectricPotential(amount = this.amount / number,
                          unit = this.unit)

    override fun to(unit: ElectricPotentialUnit) =
        ElectricPotential(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion
}