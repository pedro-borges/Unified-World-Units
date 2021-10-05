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
    constructor(value: Number,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, SCALAR)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, SCALAR)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ScalarUnit>) =
        Scalar(amount + other.into(this.unit).amount)

    override operator fun minus(other: UnitAmount<ScalarUnit>) =
        Scalar(amount - other.into(this.unit).amount)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Scalar(UnitAmountUtils.multipliedByScalar(this, other, mathContext))

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Scalar(UnitAmountUtils.dividedByScalar(this, other, mathContext))

    override fun into(unit: ScalarUnit) =
        Scalar(UnitAmountUtils.getAmountIn(this, unit))

    // endregion

    // region composition

    fun dividedBy(time: Time, mathContext: MathContext) =
        InterestRate(this.amount.div(time.amount.value, mathContext),
                     FrequencyUnit(time.unit))

    // endregion

    companion object
    {
        val ZERO = Scalar(0)
        val ONE = Scalar(1)
    }
}