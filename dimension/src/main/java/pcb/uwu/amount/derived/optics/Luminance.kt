package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminanceUnit
import pcb.uwu.util.UnitAmountUtils

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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(luminance: UnitAmount<LuminanceUnit>) =
        Luminance(amount = this.amount + (luminance to this.unit).amount,
                  unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(luminance: UnitAmount<LuminanceUnit>) =
        Luminance(amount = this.amount - (luminance to this.unit).amount,
                  unit = this.unit)

    override fun times(scalar: Number) =
        Luminance(amount = this.amount * scalar,
                  unit = this.unit)

    override fun div(scalar: Number) =
        Luminance(amount = this.amount / scalar,
                  unit = this.unit)

    override fun to(unit: LuminanceUnit) =
        Luminance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                  unit = unit)

    // endregion
}
