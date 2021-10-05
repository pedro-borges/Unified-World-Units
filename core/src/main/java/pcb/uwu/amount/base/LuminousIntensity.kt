package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.utils.UnitAmountUtils

open class LuminousIntensity : CompositeUnitAmount<LuminousIntensityUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount + (luminousIntensity to this.unit).amount,
                          unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount - (luminousIntensity to this.unit).amount,
                          unit = this.unit)

    override fun times(number: Number) =
        LuminousIntensity(amount = this.amount * number,
                          unit = this.unit)

    override fun div(number: Number) =
        LuminousIntensity(amount = this.amount / number,
                          unit = this.unit)

    override fun to(unit: LuminousIntensityUnit) =
        LuminousIntensity(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion
}