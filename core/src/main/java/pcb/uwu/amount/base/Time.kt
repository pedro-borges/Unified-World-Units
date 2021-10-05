package pcb.uwu.amount.base

import pcb.uwu.amount.derived.finance.Debt
import pcb.uwu.amount.derived.fundamental.Frequency
import pcb.uwu.amount.derived.mechanics.Pace
import pcb.uwu.amount.finance.Currency
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
                        .div(BigDecimal(1000000000)), unit)


    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(time: UnitAmount<TimeUnit>) =
        Time(amount = this.amount + (time to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(time: UnitAmount<TimeUnit>) =
        Time(amount = this.amount - (time to this.unit).amount,
             unit = this.unit)

    override fun times(number: Number) =
        Time(amount = this.amount * number,
             unit = this.unit)

    override fun div(number: Number) =
        Time(amount = this.amount / number,
             unit = this.unit)

    override fun to(unit: TimeUnit) =
        Time(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    override fun invert() =
        Frequency(amount = amount.invert(),
                  unit = FrequencyUnit(unit))

    // endregion

    // region composition

    fun times(currency: Currency) =
        Debt(amount = this.amount * currency.amount,
             unit = DebtUnit(currency.unit, this.unit))

    fun div(length: Length) =
        Pace(amount = this.amount / length.amount,
             unit = PaceUnit(this.unit, length.unit))

    // endregion
}