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

    override fun plus(amount: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount + (amount to this.unit).amount,
                     unit = this.unit)

    override fun minus(amount: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount - (amount to this.unit).amount,
                     unit = this.unit)

    override fun times(number: Number) =
        InterestRate(amount = this.amount * number,
                     unit = this.unit)

    override fun div(number: Number) =
        InterestRate(amount = this.amount / number,
                     unit = this.unit)

    override fun to(unit: FrequencyUnit) =
        InterestRate(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion

    // region composition

    fun times(money: Money) =
        Rent(amount = UnitAmountUtils.times(this, money.amount.value),
             unit = RentUnit(money.unit, this.unit))

    fun times(debt: Debt) =
        Money(amount = (this * debt).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    // endregion
}