package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.AUD

class AUD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AUD)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, AUD)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        AUD(this.amount + (currency to AUD).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        AUD(this.amount - (currency to AUD).amount)

    override fun times(scalar: Number) =
        AUD(this.amount * scalar)

    override fun div(scalar: Number) =
        AUD(this.amount / scalar)

    // endregion
}