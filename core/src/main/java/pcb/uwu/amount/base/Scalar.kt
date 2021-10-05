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

    override fun plus(amount: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount + (amount to this.unit).amount)

    override fun minus(amount: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount - (amount to this.unit).amount)

    override fun times(number: Number) =
        Scalar(amount = this.amount * number)

    override fun div(number: Number) =
        Scalar(amount = this.amount / number)

    override fun to(unit: ScalarUnit) =
        Scalar(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit))

    // endregion

    // region composition

    fun div(time: Time) =
        InterestRate(amount = this.amount / time.amount,
                     unit = FrequencyUnit(time.unit))

    // endregion

    companion object
    {
        val ZERO = Scalar(0)
        val ONE = Scalar(1)
    }
}