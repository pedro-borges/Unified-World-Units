package pcb.uwu.amount.finance

import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.finance.Debt
import pcb.uwu.amount.derived.finance.InterestRate
import pcb.uwu.amount.derived.finance.Rent
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.finance.DebtUnit
import pcb.uwu.unit.finance.CurrencyUnit
import pcb.uwu.unit.finance.RentUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.RoundingMode.HALF_EVEN

open class Currency :
    CompositeUnitAmount<CurrencyUnit>
{
    constructor(amount: Number,
                unit: CurrencyUnit)
            : super(BigDecimalAmount(amount.toString()).withScale(unit.defaultFractionDigits, HALF_EVEN), unit)

    constructor(amount: String,
                unit: CurrencyUnit)
            : super(BigDecimalAmount(amount).withScale(unit.defaultFractionDigits, HALF_EVEN), unit)

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
             unit = RentUnit(this.unit, time.unit))

    operator fun times(interestRate: InterestRate) =
        Rent(amount = this.amount * interestRate.amount,
             unit = RentUnit(this.unit, interestRate.unit))

    operator fun times(time: Time) =
        Debt(amount = this.amount * time.amount,
             unit = DebtUnit(this.unit, time.unit))

    // endregion
}