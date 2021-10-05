package pcb.uwu.amount.base

import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TemperatureUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Temperature : CompositeUnitAmount<TemperatureUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: TemperatureUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: TemperatureUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(value: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: TemperatureUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: TemperatureUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<TemperatureUnit>) =
        Temperature(amount = this.amount + other.into(this.unit).amount,
                    unit = this.unit)

    override operator fun minus(other: UnitAmount<TemperatureUnit>) =
        Temperature(amount = this.amount - other.into(this.unit).amount,
                    unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Temperature(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                    unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Temperature(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                    unit = this.unit)

    override fun into(unit: TemperatureUnit) =
        Temperature(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                    unit = unit)

    // endregion
}