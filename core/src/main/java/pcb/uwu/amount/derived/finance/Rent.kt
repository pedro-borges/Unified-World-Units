package pcb.uwu.amount.derived.finance

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.finance.CurrencyUnit
import pcb.uwu.unit.finance.RentUnit
import pcb.uwu.utils.UnitAmountUtils

class Rent : CompositeUnitAmount<RentUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: RentUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: RentUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<RentUnit>) =
        Rent(amount = this.amount + (amount to this.unit).amount,
             unit = this.unit)

    override fun minus(amount: UnitAmount<RentUnit>) =
        Rent(amount = this.amount - (amount to this.unit).amount,
             unit = this.unit)

    override fun times(number: Number) =
        Rent(amount = this.amount * number,
             unit = this.unit)

    override fun div(number: Number) =
        Rent(amount = this.amount / number,
             unit = this.unit)

    override fun to(unit: RentUnit) =
        Rent(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    operator fun times(time: Time) =
        Money(amount = super.times(time).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    // endregion
}