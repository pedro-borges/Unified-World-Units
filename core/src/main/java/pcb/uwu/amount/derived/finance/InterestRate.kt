package pcb.uwu.amount.derived.finance

import pcb.uwu.amount.finance.Money
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.unit.finance.CurrencyUnit
import pcb.uwu.unit.finance.RentUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

class InterestRate : CompositeUnitAmount<FrequencyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: FrequencyUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: FrequencyUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount + other.into(this.unit).amount,
                     unit = this.unit)

    override operator fun minus(other: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount - other.into(this.unit).amount,
                     unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        InterestRate(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                     unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        InterestRate(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                     unit = this.unit)

    override fun into(unit: FrequencyUnit) =
        InterestRate(amount = UnitAmountUtils.getAmountIn(this, unit),
                     unit = unit)

    // endregion

    // region composition

    fun times(money: Money, mathContext: MathContext) =
        Rent(amount = UnitAmountUtils.multipliedByScalar(this, money.amount.value, mathContext),
             unit = RentUnit(money.unit, this.unit))

    fun times(debt: Debt, mathContext: MathContext) =
        Money(amount = super.times(debt, mathContext).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    // endregion
}