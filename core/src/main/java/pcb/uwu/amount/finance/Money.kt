package pcb.uwu.amount.finance

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.Debt
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.amount.derived.finance.Rent
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.finance.CurrencyUnit
import pcb.uwu.unit.finance.RentUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode.HALF_EVEN

open class Money :
    CompositeUnitAmount<CurrencyUnit>
{
    constructor(amount: Number,
                unit: CurrencyUnit)
            : super(BigDecimalAmount(amount.toString()).withScale(unit.defaultFractionDigits, HALF_EVEN), unit)

    constructor(amount: String,
                unit: CurrencyUnit)
            : super(BigDecimalAmount(amount).withScale(unit.defaultFractionDigits, HALF_EVEN), unit)

    //region UnitAmount

    override operator fun plus(other: UnitAmount<CurrencyUnit>) =
        Money(amount = this.amount + other.into(this.unit).amount,
              unit = this.unit)

    override operator fun minus(other: UnitAmount<CurrencyUnit>) =
        Money(amount = this.amount - other.into(this.unit).amount,
              unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Money(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Money(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun into(unit: CurrencyUnit) =
        Money(amount = UnitAmountUtils.getAmountIn(this, unit),
              unit = this.unit)

    // endregion

    // region composition

    fun div(time: Time, mathContext: MathContext) =
        Rent(amount = this.amount.div(time.amount.value, mathContext),
             unit = RentUnit(this.unit, time.unit))

    fun times(interestRate: InterestRate, mathContext: MathContext) =
        Rent(amount = this.amount.times(interestRate.amount.value, mathContext),
             unit = RentUnit(this.unit, interestRate.unit))

    fun times(time: Time, mathContext: MathContext) =
        Debt(amount = UnitAmountUtils.multipliedByScalar(this, time.amount.value, mathContext),
             unit = DebtUnit(this.unit, time.unit))

    // endregion
}