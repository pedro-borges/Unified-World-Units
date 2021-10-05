package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.CHF

class CHF : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CHF)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, CHF)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        CHF(this.amount + (currency to CHF).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        CHF(this.amount - (currency to CHF).amount)

    override fun times(scalar: Number) =
        CHF(this.amount * scalar)

    override fun div(scalar: Number) =
        CHF(this.amount / scalar)

    // endregion
}