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

    override operator fun plus(other: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount + other.into(this.unit).amount,
                          unit = this.unit)

    override operator fun minus(other: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount - other.into(this.unit).amount,
                          unit = this.unit)

    override operator fun times(other: Number) =
        LuminousIntensity(amount = this.amount * other,
                          unit = this.unit)

    override operator fun div(other: Number) =
        LuminousIntensity(amount = this.amount / other,
                          unit = this.unit)

    override fun into(unit: LuminousIntensityUnit) =
        LuminousIntensity(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion
}