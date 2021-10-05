package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.EUR

class EUR : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, EUR)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, EUR)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        EUR(this.amount + (currency to EUR).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        EUR(this.amount - (currency to EUR).amount)

    override fun times(scalar: Number) =
        EUR(this.amount * scalar)

    override fun div(scalar: Number) =
        EUR(this.amount / scalar)

    // endregion
}