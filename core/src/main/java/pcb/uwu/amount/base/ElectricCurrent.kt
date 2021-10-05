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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount + (electricCurrrent to this.unit).amount,
                        unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricCurrrent: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount - (electricCurrrent to this.unit).amount,
                        unit = this.unit)

    override fun times(scalar: Number) =
        ElectricCurrent(amount = this.amount * scalar,
                        unit = this.unit)

    override fun div(scalar: Number) =
        ElectricCurrent(amount = this.amount / scalar,
                        unit = this.unit)

    override fun to(unit: ElectricCurrentUnit) =
        ElectricCurrent(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                        unit = unit)

    // endregion
}