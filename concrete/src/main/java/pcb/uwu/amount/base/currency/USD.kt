package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.USD

class USD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, USD)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, USD)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        USD(this.amount + (currency to USD).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        USD(this.amount - (currency to USD).amount)

    override fun times(scalar: Number) =
        USD(this.amount * scalar)

    override fun div(scalar: Number) =
        USD(this.amount / scalar)

    // endregion
}