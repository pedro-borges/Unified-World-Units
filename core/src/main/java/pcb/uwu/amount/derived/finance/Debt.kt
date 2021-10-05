package pcb.uwu.amount.derived.finance

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.finance.CurrencyUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

class Debt : CompositeUnitAmount<DebtUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: DebtUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: DebtUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<DebtUnit>) =
        Debt(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<DebtUnit>) =
        Debt(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Debt(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Debt(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun into(unit: DebtUnit) =
        Debt(amount = UnitAmountUtils.getAmountIn(this, unit),
             unit = this.unit)

    // endregion

    // region composition

    fun multiply(interestRate: InterestRate, mathContext: MathContext) =
        Money(amount = super.multiply(interestRate, mathContext).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    fun div(time: Time, mathContext: MathContext) =
        Money(amount = super.div(time, mathContext).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    fun div(money: Money, mathContext: MathContext) =
        Time(amount = super.div(money, mathContext).amount,
             unit = this.unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    // endregion
}