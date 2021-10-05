package pcb.uwu.amount.base

import pcb.uwu.core.Amount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TemperatureUnit
import pcb.uwu.util.UnitAmountUtils
import java.math.BigDecimal

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
    constructor(amount: Amount,
                magnitude: Magnitude = NATURAL,
                unit: TemperatureUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(temperature: UnitAmount<TemperatureUnit>) =
        Temperature(amount = this.amount + (temperature to this.unit).amount,
                    unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(temperature: UnitAmount<TemperatureUnit>) =
        Temperature(amount = this.amount - (temperature to this.unit).amount,
                    unit = this.unit)

    override fun times(scalar: Number) =
        Temperature(amount = this.amount * scalar,
                    unit = this.unit)

    override fun div(scalar: Number) =
        Temperature(amount = this.amount / scalar,
                    unit = this.unit)

    override fun to(unit: TemperatureUnit) =
        Temperature(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                    unit = unit)

    // endregion
}