package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricCapacitance : CompositeUnitAmount<ElectricCapacitanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCapacitanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCapacitanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        ElectricCapacitance(amount = this.amount + (electricCapacitance to this.unit).amount,
                            unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        ElectricCapacitance(amount = this.amount - (electricCapacitance to this.unit).amount,
                            unit = this.unit)

    override fun times(number: Number) =
        ElectricCapacitance(amount = this.amount * number,
                            unit = this.unit)

    override fun div(number: Number) =
        ElectricCapacitance(amount = this.amount / number,
                            unit = this.unit)

    override fun to(unit: ElectricCapacitanceUnit) =
        ElectricCapacitance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                            unit = unit)

    // endregion
}