package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.USDUnit

class USD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, USDUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, USDUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        USD(this.amount + (currency to USDUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        USD(this.amount - (currency to USDUnit).amount)

    override fun times(scalar: Number) =
        USD(this.amount * scalar)

    override fun div(scalar: Number) =
        USD(this.amount / scalar)

    // endregion
}
