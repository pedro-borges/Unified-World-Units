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

    override operator fun times(other: Number) =
        Debt(amount = this.amount * other,
             unit = this.unit)

    override operator fun div(other: Number) =
        Debt(amount = this.amount / other,
             unit = this.unit)

    override fun into(unit: DebtUnit) =
        Debt(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    fun times(interestRate: InterestRate) =
        Money(amount = (this * interestRate).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    fun div(time: Time) =
        Money(amount = (this / time).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    fun div(money: Money) =
        Time(amount = (this / money).amount,
             unit = this.unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    // endregion
}