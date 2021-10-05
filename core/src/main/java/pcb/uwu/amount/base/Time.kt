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
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: TimeUnit)
            : super(amount, magnitude, unit)

    constructor(duration: Duration,
                unit: TimeUnit)
            : super(unit.translationFromCanonical.apply(BigDecimalAmount(duration.toNanos()))
                        .div(BigDecimal(1000000000), MathContext.UNLIMITED), unit)


    // region UnitAmount

    override operator fun plus(other: UnitAmount<TimeUnit>) =
        Time(value = amount + other.into(unit).amount,
             unit = unit)

    override operator fun minus(other: UnitAmount<TimeUnit>) =
        Time(value = amount - other.into(unit).amount,
             unit = unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Time(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Time(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = unit)

    override fun into(unit: TimeUnit) =
        Time(value = UnitAmountUtils.getAmountIn(this, unit),
             unit = unit)

    override fun invert(mathContext: MathContext) =
        Frequency(amount.invert(mathContext), FrequencyUnit(unit))

    // endregion

    // region composition

    fun multipliedBy(money: Money, mathContext: MathContext) =
        Debt(UnitAmountUtils.multipliedByScalar(this, money.amount.value, mathContext),
             DebtUnit(money.unit, this.unit))

    fun dividedBy(length: Length, mathContext: MathContext) =
        Pace(this.amount.div(length.amount.value, mathContext), PaceUnit(this.unit, length.unit))

    // endregion
}