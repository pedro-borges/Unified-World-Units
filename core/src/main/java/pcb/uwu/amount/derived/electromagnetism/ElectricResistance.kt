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

    override operator fun plus(other: UnitAmount<ElectricResistanceUnit>) =
        ElectricResistance(amount = this.amount + other.into(this.unit).amount,
                           unit = this.unit)

    override operator fun minus(other: UnitAmount<ElectricResistanceUnit>) =
        ElectricResistance(amount = this.amount - other.into(this.unit).amount,
                           unit = this.unit)

    override operator fun times(other: Number) =
        ElectricResistance(amount = this.amount * other,
                           unit = this.unit)

    override operator fun div(other: Number) =
        ElectricResistance(amount = this.amount / other,
                           unit = this.unit)

    override fun into(unit: ElectricResistanceUnit) =
        ElectricResistance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                           unit = unit)

    // endregion
}