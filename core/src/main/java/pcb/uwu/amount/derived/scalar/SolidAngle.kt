package pcb.uwu.amount.derived.scalar

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.scalar.SolidAngleUnit
import pcb.uwu.utils.UnitAmountUtils

open class SolidAngle : CompositeUnitAmount<SolidAngleUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount + other.into(this.unit).amount,
                   unit = this.unit)

    override operator fun minus(other: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount - other.into(this.unit).amount,
                   unit = this.unit)

    override operator fun times(other: Number) =
        SolidAngle(amount = this.amount * other,
                   unit = this.unit)

    override operator fun div(other: Number) =
        SolidAngle(amount = this.amount / other,
                   unit = this.unit)

    override fun into(unit: SolidAngleUnit) =
        SolidAngle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                   unit = unit)

    // endregion
}