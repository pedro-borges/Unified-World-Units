package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.GBPUnit

class GBP : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, GBPUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, GBPUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        GBP(this.amount + (currency to GBPUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        GBP(this.amount - (currency to GBPUnit).amount)

    override fun times(scalar: Number) =
        GBP(this.amount * scalar)

    override fun div(scalar: Number) =
        GBP(this.amount / scalar)

    // endregion
}