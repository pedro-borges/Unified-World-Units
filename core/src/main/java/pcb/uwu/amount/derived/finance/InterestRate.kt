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

    override operator fun plus(other: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount + other.into(this.unit).amount,
                     unit = this.unit)

    override operator fun minus(other: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount - other.into(this.unit).amount,
                     unit = this.unit)

    override operator fun times(other: Number) =
        InterestRate(amount = this.amount * other,
                     unit = this.unit)

    override operator fun div(other: Number) =
        InterestRate(amount = this.amount / other,
                     unit = this.unit)

    override fun into(unit: FrequencyUnit) =
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