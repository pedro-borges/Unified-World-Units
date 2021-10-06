package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.AUDUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit

class AUD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, AUDUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, AUDUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        AUD(this.amount + (currency to AUDUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        AUD(this.amount - (currency to AUDUnit).amount)

    override fun times(scalar: Number) =
        AUD(this.amount * scalar)

    override fun div(scalar: Number) =
        AUD(this.amount / scalar)

    // endregion
}
