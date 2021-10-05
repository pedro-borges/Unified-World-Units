package pcb.uwu.amount.derived.scalar

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.scalar.AngleUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

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

    override operator fun plus(other: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount + other.into(this.unit).amount,
              unit = this.unit)

    override operator fun minus(other: UnitAmount<AngleUnit>) =
        Angle(amount = this.amount - other.into(this.unit).amount,
              unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Angle(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Angle(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun into(unit: AngleUnit) =
        Angle(amount = UnitAmountUtils.getAmountIn(this, unit),
              unit = unit)

    // endregion
}