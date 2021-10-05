package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CHFUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit

class CHF : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CHFUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, CHFUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        CHF(this.amount + (currency to CHFUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        CHF(this.amount - (currency to CHFUnit).amount)

    override fun times(scalar: Number) =
        CHF(this.amount * scalar)

    override fun div(scalar: Number) =
        CHF(this.amount / scalar)

    // endregion
}