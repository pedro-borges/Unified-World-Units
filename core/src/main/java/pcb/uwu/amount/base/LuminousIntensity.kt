package pcb.uwu.amount.base

import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class LuminousIntensity : CompositeUnitAmount<LuminousIntensityUnit>
{
    @JvmOverloads
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(value = amount + other.into(unit).amount,
                          unit = unit)

    override operator fun minus(other: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(value = amount - other.into(unit).amount,
                          unit = unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        LuminousIntensity(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                          unit = unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        LuminousIntensity(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                          unit = unit)

    override fun into(unit: LuminousIntensityUnit) =
        LuminousIntensity(value = UnitAmountUtils.getAmountIn(this, unit),
                                 unit = unit)

    // endregion
}