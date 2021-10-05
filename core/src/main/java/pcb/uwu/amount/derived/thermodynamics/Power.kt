package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Power : CompositeUnitAmount<PowerUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<PowerUnit>) =
        Power(amount = this.amount + other.into(this.unit).amount,
              unit = this.unit)

    override operator fun minus(other: UnitAmount<PowerUnit>) =
        Power(amount = this.amount - other.into(this.unit).amount,
              unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Power(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Power(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun into(unit: PowerUnit) =
        Power(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion
}