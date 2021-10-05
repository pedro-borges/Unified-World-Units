package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricConductance : CompositeUnitAmount<ElectricConductanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricConductanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricConductanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<ElectricConductanceUnit>) =
        ElectricConductance(amount = this.amount + (amount to this.unit).amount,
                            unit = this.unit)

    override fun minus(amount: UnitAmount<ElectricConductanceUnit>) =
        ElectricConductance(amount = this.amount - (amount to this.unit).amount,
                            unit = this.unit)

    override fun times(number: Number) =
        ElectricConductance(amount = this.amount * number,
                            unit = this.unit)

    override fun div(number: Number) =
        ElectricConductance(amount = this.amount / number,
                            unit = this.unit)

    override fun to(unit: ElectricConductanceUnit) =
        ElectricConductance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                            unit = unit)

    // endregion
}