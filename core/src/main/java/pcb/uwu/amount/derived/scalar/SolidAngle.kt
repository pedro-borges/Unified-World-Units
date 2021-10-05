package pcb.uwu.amount.derived.scalar

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.scalar.SolidAngleUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class SolidAngle : CompositeUnitAmount<SolidAngleUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount + other.into(this.unit).amount,
                   unit = this.unit)

    override operator fun minus(other: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount - other.into(this.unit).amount,
                   unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        SolidAngle(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                   unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        SolidAngle(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                   unit = this.unit)

    override fun into(unit: SolidAngleUnit) =
        SolidAngle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                   unit = unit)

    // endregion
}