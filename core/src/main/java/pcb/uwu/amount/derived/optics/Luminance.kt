package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class Luminance : CompositeUnitAmount<LuminanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<LuminanceUnit>) =
        Luminance(amount = this.amount + (amount to this.unit).amount,
                  unit = this.unit)

    override fun minus(amount: UnitAmount<LuminanceUnit>) =
        Luminance(amount = this.amount - (amount to this.unit).amount,
                  unit = this.unit)

    override fun times(number: Number) =
        Luminance(amount = this.amount * number,
                  unit = this.unit)

    override fun div(number: Number) =
        Luminance(amount = this.amount / number,
                  unit = this.unit)

    override fun to(unit: LuminanceUnit) =
        Luminance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                  unit = unit)

    // endregion
}