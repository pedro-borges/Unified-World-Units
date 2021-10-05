package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricCurrent : CompositeUnitAmount<ElectricCurrentUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCurrentUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCurrentUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount + (amount to this.unit).amount,
                        unit = this.unit)

    override fun minus(amount: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount - (amount to this.unit).amount,
                        unit = this.unit)

    override fun times(number: Number) =
        ElectricCurrent(amount = this.amount * number,
                        unit = this.unit)

    override fun div(number: Number) =
        ElectricCurrent(amount = this.amount / number,
                        unit = this.unit)

    override fun to(unit: ElectricCurrentUnit) =
        ElectricCurrent(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                        unit = unit)

    // endregion
}