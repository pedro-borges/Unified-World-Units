package pcb.uwu.amount.derived.economics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.acoustics.FrequencyUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.RentUnit
import pcb.uwu.util.UnitAmountUtils

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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(interestRate: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount + (interestRate to this.unit).amount,
                     unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(interestRate: UnitAmount<FrequencyUnit>) =
        InterestRate(amount = this.amount - (interestRate to this.unit).amount,
                     unit = this.unit)

    override fun times(scalar: Number) =
        InterestRate(amount = this.amount * scalar,
                     unit = this.unit)

    override fun div(scalar: Number) =
        InterestRate(amount = this.amount / scalar,
                     unit = this.unit)

    override fun to(unit: FrequencyUnit) =
        InterestRate(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion

    // region composition

    fun times(currency: Currency) =
        Rent(amount = UnitAmountUtils.times(this, currency.amount.amount),
             unit = RentUnit(interestRateUnit = this.unit,
                             currency = currency.unit))

    fun times(debt: Debt) =
        Currency(amount = (this * debt).amount,
                 unit = this.unit.unitCounter.findUnit(CurrencyUnit::class)!!)

    // endregion
}
