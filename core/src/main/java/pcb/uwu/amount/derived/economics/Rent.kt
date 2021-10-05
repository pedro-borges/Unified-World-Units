package pcb.uwu.amount.derived.economics

import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.RentUnit
import pcb.uwu.util.UnitAmountUtils

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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(rent: UnitAmount<RentUnit>) =
        Rent(amount = this.amount + (rent to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(rent: UnitAmount<RentUnit>) =
        Rent(amount = this.amount - (rent to this.unit).amount,
             unit = this.unit)

    override fun times(scalar: Number) =
        Rent(amount = this.amount * scalar,
             unit = this.unit)

    override fun div(scalar: Number) =
        Rent(amount = this.amount / scalar,
             unit = this.unit)

    override fun to(unit: RentUnit) =
        Rent(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    operator fun times(time: Time) =
        Currency(amount = super.times(time).amount,
                 unit = this.unit.unitCounter.findUnit(CurrencyUnit::class)!!)

    // endregion
}