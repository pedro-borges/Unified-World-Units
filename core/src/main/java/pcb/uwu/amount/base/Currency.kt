package pcb.uwu.amount.base

import pcb.uwu.amount.derived.finance.Debt
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.amount.derived.finance.Rent
import pcb.uwu.core.Amount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.finance.RentUnit
import pcb.uwu.util.UnitAmountUtils
import java.math.RoundingMode.HALF_EVEN

open class Currency :
    CompositeUnitAmount<CurrencyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: CurrencyUnit)
            : super(Amount(amount).withScale(unit.defaultFractionDigits, HALF_EVEN), magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: CurrencyUnit)
            : super(Amount(amount).withScale(unit.defaultFractionDigits, HALF_EVEN), magnitude, unit)

    //region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        Currency(amount = this.amount + (currency to this.unit).amount,
                 unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        Currency(amount = this.amount - (currency to this.unit).amount,
                 unit = this.unit)

    override fun times(scalar: Number) =
        Currency(amount = this.amount * scalar,
                 unit = this.unit)

    override fun div(scalar: Number) =
        Currency(amount = this.amount / scalar,
                 unit = this.unit)

    override fun to(unit: CurrencyUnit) =
        Currency(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                 unit = this.unit)

    // endregion

    // region composition

    operator fun div(time: Time) =
        Rent(amount = this.amount / time.amount,
             unit = RentUnit(currency = this.unit,
                             time = time.unit))

    operator fun times(interestRate: InterestRate) =
        Rent(amount = this.amount * interestRate.amount,
             unit = RentUnit(currency = this.unit,
                             interestRateUnit = interestRate.unit))

    operator fun times(time: Time) =
        Debt(amount = this.amount * time.amount,
             unit = DebtUnit(currencyUnit = this.unit,
                             timeUnit = time.unit))

    // endregion
}