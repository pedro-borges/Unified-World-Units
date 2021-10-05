package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricCharge : CompositeUnitAmount<ElectricChargeUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(amount = this.amount + (amount to this.unit).amount,
                       unit = this.unit)

    override fun minus(amount: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(amount = this.amount - (amount to unit).amount,
                       unit = this.unit)

    override fun times(number: Number) =
        ElectricCharge(amount = this.amount * number,
                       unit = this.unit)

    override fun div(number: Number) =
        ElectricCharge(amount = this.amount / number,
                       unit = this.unit)

    override fun to(unit: ElectricChargeUnit) =
        ElectricCharge(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                       unit = unit)

    // endregion
}