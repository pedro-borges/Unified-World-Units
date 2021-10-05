package pcb.uwu.amount.derived.scalar

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.scalar.AngleUnit
import pcb.uwu.utils.UnitAmountUtils

open class Angle : CompositeUnitAmount<AngleUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AngleUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AngleUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount + (amount to this.unit).amount,
              unit = this.unit)

    override fun minus(amount: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount - (amount to this.unit).amount,
              unit = this.unit)

    override fun times(number: Number) =
        Angle(amount = this.amount * number,
              unit = this.unit)

    override fun div(number: Number) =
        Angle(amount = this.amount / number,
              unit = this.unit)

    override fun to(unit: AngleUnit) =
        Angle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}