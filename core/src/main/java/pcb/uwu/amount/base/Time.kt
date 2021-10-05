package pcb.uwu.amount.base

import pcb.uwu.amount.derived.finance.Debt
import pcb.uwu.amount.derived.fundamental.Frequency
import pcb.uwu.amount.derived.mechanics.Pace
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.unit.derived.mechanics.PaceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext
import java.time.Duration

open class Time : CompositeUnitAmount<TimeUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(amount, magnitude, unit)

    constructor(duration: Duration,
                unit: TimeUnit)
            : super(unit.translationFromCanonical.apply(BigDecimalAmount(duration.toNanos()))
                        .div(BigDecimal(1000000000), MathContext.UNLIMITED), unit)


    // region UnitAmount

    override operator fun plus(other: UnitAmount<TimeUnit>) =
        Time(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<TimeUnit>) =
        Time(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Time(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Time(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun into(unit: TimeUnit) =
        Time(amount = UnitAmountUtils.getAmountIn(this, unit),
             unit = this.unit)

    override fun invert(mathContext: MathContext) =
        Frequency(amount.invert(mathContext), FrequencyUnit(unit))

    // endregion

    // region composition

    fun multipliedBy(money: Money, mathContext: MathContext) =
        Debt(amount = UnitAmountUtils.multipliedByScalar(this, money.amount.value, mathContext),
             unit = DebtUnit(money.unit, this.unit))

    fun dividedBy(length: Length, mathContext: MathContext) =
        Pace(amount = this.amount.div(length.amount.value, mathContext),
             unit = PaceUnit(this.unit, length.unit))

    // endregion
}