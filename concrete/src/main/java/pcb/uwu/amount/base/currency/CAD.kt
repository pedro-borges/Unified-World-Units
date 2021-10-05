package pcb.uwu.amount.base.currency

import pcb.uwu.amount.base.Currency
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CurrencyUnit
import pcb.uwu.unit.base.CurrencyUnit.Companion.CAD

class CAD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CAD)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, CAD)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        CAD(this.amount + (currency to CAD).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        CAD(this.amount - (currency to CAD).amount)

    override fun times(scalar: Number) =
        CAD(this.amount * scalar)

    override fun div(scalar: Number) =
        CAD(this.amount / scalar)

    // endregion
}