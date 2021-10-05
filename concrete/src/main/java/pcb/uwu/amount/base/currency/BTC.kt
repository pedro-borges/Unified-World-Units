package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.BTC

class BTC : Currency
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, BTC)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, BTC)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        BTC(this.amount + (currency to BTC).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        BTC(this.amount - (currency to BTC).amount)

    override fun times(scalar: Number) =
        BTC(this.amount * scalar)

    override fun div(scalar: Number) =
        BTC(this.amount / scalar)

    // endregion
}