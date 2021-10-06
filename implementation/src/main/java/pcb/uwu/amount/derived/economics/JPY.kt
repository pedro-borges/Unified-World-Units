package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.JPYUnit

class JPY : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, JPYUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, JPYUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        JPY(this.amount + (currency to JPYUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        JPY(this.amount - (currency to JPYUnit).amount)

    override fun times(scalar: Number) =
        JPY(this.amount * scalar)

    override fun div(scalar: Number) =
        JPY(this.amount / scalar)

    // endregion
}
