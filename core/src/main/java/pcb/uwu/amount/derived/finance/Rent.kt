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
import java.math.BigDecimal
import java.math.MathContext

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

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Rent(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Rent(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun into(unit: RentUnit) =
        Rent(amount = UnitAmountUtils.getAmountIn(this, unit),
             unit = this.unit)

    // endregion

    // region composition

    fun multipliedBy(time: Time, mathContext: MathContext) =
        Money(amount = super.times(time, mathContext).amount,
              unit = this.unit.unitCounter.findUnit(CurrencyUnit::class.java)!!)

    // endregion
}