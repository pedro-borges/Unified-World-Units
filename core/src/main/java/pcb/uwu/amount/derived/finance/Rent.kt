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

    override operator fun plus(other: UnitAmount<RentUnit>) =
        Rent(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<RentUnit>) =
        Rent(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override operator fun times(other: Number) =
        Rent(amount = this.amount * other,
             unit = this.unit)

    override operator fun div(other: Number) =
        Rent(amount = this.amount / other,
             unit = this.unit)

    override fun into(unit: RentUnit) =
        Rent(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    fun times(time: Time) =
        Money(amount = (this * time).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    // endregion
}