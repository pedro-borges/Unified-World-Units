package pcb.uwu.amount.derived.economics

import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.DebtUnit
import pcb.uwu.util.UnitAmountUtils

open class Debt : CompositeUnitAmount<DebtUnit>
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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(debt: UnitAmount<DebtUnit>) =
        Debt(amount = this.amount + (debt to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(debt: UnitAmount<DebtUnit>) =
        Debt(amount = this.amount - (debt to this.unit).amount,
             unit = this.unit)

    override fun times(scalar: Number) =
        Debt(amount = this.amount * scalar,
             unit = this.unit)

    override fun div(scalar: Number) =
        Debt(amount = this.amount / scalar,
             unit = this.unit)

    override fun to(unit: DebtUnit) =
        Debt(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    open operator fun times(interestRate: InterestRate) =
        Currency(amount = super.times(interestRate).amount,
                 unit = this.unit.unitCounter.findUnit(CurrencyUnit::class)!!)

    open operator fun div(time: Time) =
        Currency(amount = super.div(time).amount,
                 unit = this.unit.unitCounter.findUnit(CurrencyUnit::class)!!)

    open operator fun div(currency: Currency) =
        Time(amount = super.div(currency).amount,
             unit = this.unit.unitCounter.findUnit(TimeUnit::class)!!)

    // endregion
}