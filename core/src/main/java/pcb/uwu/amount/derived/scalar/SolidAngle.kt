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

    override fun plus(amount: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount + (amount to this.unit).amount,
                   unit = this.unit)

    override fun minus(amount: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount - (amount to this.unit).amount,
                   unit = this.unit)

    override fun times(number: Number) =
        SolidAngle(amount = this.amount * number,
                   unit = this.unit)

    override fun div(number: Number) =
        SolidAngle(amount = this.amount / number,
                   unit = this.unit)

    override fun to(unit: SolidAngleUnit) =
        SolidAngle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                   unit = unit)

    // endregion
}