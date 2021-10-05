package pcb.uwu.amount.base

import pcb.uwu.amount.derived.mechanics.Acceleration
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Mass : CompositeUnitAmount<MassUnit>
{
    @JvmOverloads
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<MassUnit>) =
        Mass(value = amount + other.into(unit).amount,
             unit = unit)

    override operator fun minus(other: UnitAmount<MassUnit>) =
        Mass(value = amount - other.into(unit).amount,
             unit = unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Mass(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Mass(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = unit)

    override fun into(unit: MassUnit) =
        Mass(value = UnitAmountUtils.getAmountIn(this, unit),
                    unit = unit)

    // endregion

    // region composition

    fun multipliedBy(acceleration: Acceleration, mathContext: MathContext): Force
    {
        return Force(this.amount.times(acceleration.amount.value, mathContext), ForceUnit(this.unit, acceleration.unit))
    }

    // endregion
}