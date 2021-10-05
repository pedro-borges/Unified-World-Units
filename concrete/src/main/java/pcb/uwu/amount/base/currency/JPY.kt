package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.JPY

class JPY : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JPY)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, JPY)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        JPY(this.amount + (currency to JPY).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        JPY(this.amount - (currency to JPY).amount)

    override fun times(scalar: Number) =
        JPY(this.amount * scalar)

    override fun div(scalar: Number) =
        JPY(this.amount / scalar)

    // endregion
}