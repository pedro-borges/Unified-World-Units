package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.GBP

class GBP : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, GBP)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, GBP)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        GBP(this.amount + (currency to GBP).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        GBP(this.amount - (currency to GBP).amount)

    override fun times(scalar: Number) =
        GBP(this.amount * scalar)

    override fun div(scalar: Number) =
        GBP(this.amount / scalar)

    // endregion
}