package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class ElectricResistance : CompositeUnitAmount<ElectricResistanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricResistanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricResistanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricResistance: UnitAmount<ElectricResistanceUnit>) =
        ElectricResistance(amount = this.amount + (electricResistance to this.unit).amount,
                           unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricResistance: UnitAmount<ElectricResistanceUnit>) =
        ElectricResistance(amount = this.amount - (electricResistance to this.unit).amount,
                           unit = this.unit)

    override fun times(scalar: Number) =
        ElectricResistance(amount = this.amount * scalar,
                           unit = this.unit)

    override fun div(scalar: Number) =
        ElectricResistance(amount = this.amount / scalar,
                           unit = this.unit)

    override fun to(unit: ElectricResistanceUnit) =
        ElectricResistance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                           unit = unit)

    // endregion
}