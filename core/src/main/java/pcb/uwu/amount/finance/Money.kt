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

open class Money(amount: BigDecimalAmount, unit: CurrencyUnit) :
    CompositeUnitAmount<CurrencyUnit>(amount.withScale(unit.defaultFractionDigits, HALF_EVEN), unit)
{
    constructor(value: Number, unit: CurrencyUnit) : this(value.toString(), unit)
    constructor(value: String, unit: CurrencyUnit) : this(BigDecimal(value), unit)
    constructor(value: BigDecimal, unit: CurrencyUnit) : this(BigDecimalAmount(value), unit)

    //region UnitAmount

    override operator fun plus(other: UnitAmount<CurrencyUnit>) =
        Money(amount + other.into(this.unit).amount, unit)

    override operator fun minus(other: UnitAmount<CurrencyUnit>) =
        Money(amount - other.into(this.unit).amount, unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Money(UnitAmountUtils.multipliedByScalar(this, other, mathContext), unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Money(UnitAmountUtils.dividedByScalar(this, other, mathContext), unit)

    override fun into(unit: CurrencyUnit) =
        Money(UnitAmountUtils.getAmountIn(this, unit), unit)

    // endregion

    // region composition

    fun dividedBy(time: Time, mathContext: MathContext) =
        Rent(amount.div(time.amount.value, mathContext),
             RentUnit(this.unit, time.unit))

    fun multipliedBy(interestRate: InterestRate, mathContext: MathContext) =
        Rent(this.amount.times(interestRate.amount.value, mathContext),
             RentUnit(this.unit, interestRate.unit))

    fun multipliedBy(time: Time, mathContext: MathContext): Debt
    {
        return Debt(UnitAmountUtils.multipliedByScalar(this, time.amount.value, mathContext),
                    DebtUnit(this.unit, time.unit))
    }

    // endregion
}