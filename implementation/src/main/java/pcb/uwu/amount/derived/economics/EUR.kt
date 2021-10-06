package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CurrencyUnit
import pcb.uwu.unit.derived.economics.EURUnit

class EUR : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, EURUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, EURUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        EUR(this.amount + (currency to EURUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        EUR(this.amount - (currency to EURUnit).amount)

    override fun times(scalar: Number) =
        EUR(this.amount * scalar)

    override fun div(scalar: Number) =
        EUR(this.amount / scalar)

    // endregion
}
