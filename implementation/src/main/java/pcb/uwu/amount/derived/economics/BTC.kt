package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.BTCUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit

class BTC : Currency
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, BTCUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, BTCUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        BTC(this.amount + (currency to BTCUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        BTC(this.amount - (currency to BTCUnit).amount)

    override fun times(scalar: Number) =
        BTC(this.amount * scalar)

    override fun div(scalar: Number) =
        BTC(this.amount / scalar)

    // endregion
}