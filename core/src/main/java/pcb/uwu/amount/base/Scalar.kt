package pcb.uwu.amount.base

import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.ScalarUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.util.UnitAmountUtils

class Scalar : CompositeUnitAmount<ScalarUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, ScalarUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, ScalarUnit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(scalar: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount + (scalar to this.unit).amount)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(scalar: UnitAmount<ScalarUnit>) =
        Scalar(amount = this.amount - (scalar to this.unit).amount)

    override fun times(scalar: Number) =
        Scalar(amount = this.amount * scalar)

    override fun div(scalar: Number) =
        Scalar(amount = this.amount / scalar)

    override fun to(unit: ScalarUnit) =
        Scalar(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit))

    // endregion

    // region composition

    fun div(time: Time) =
        InterestRate(amount = this.amount / time.amount,
                     unit = FrequencyUnit(time.unit))

    // endregion
}