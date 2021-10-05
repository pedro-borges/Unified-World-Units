package pcb.uwu.amount.base

import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.ScalarUnit
import pcb.uwu.unit.base.ScalarUnit.Companion.SCALAR
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

class Scalar : CompositeUnitAmount<ScalarUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SCALAR)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SCALAR)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount + other.into(this.unit).amount)

    override operator fun minus(other: UnitAmount<ScalarUnit>) =
        Scalar(amount = amount - other.into(this.unit).amount)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Scalar(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext))

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Scalar(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext))

    override fun into(unit: ScalarUnit) =
        Scalar(amount = UnitAmountUtils.getAmountIn(this, unit))

    // endregion

    // region composition

    fun dividedBy(time: Time, mathContext: MathContext) =
        InterestRate(amount = this.amount.div(time.amount.value, mathContext),
                     unit = FrequencyUnit(time.unit))

    // endregion

    companion object
    {
        val ZERO = Scalar(0)
        val ONE = Scalar(1)
    }
}