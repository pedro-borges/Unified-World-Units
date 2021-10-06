package pcb.uwu.amount.derived.economics

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.economics.CADUnit
import pcb.uwu.unit.derived.economics.CurrencyUnit

class CAD : Currency
{
    @JvmOverloads
    constructor(amount: Number, magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CADUnit)

    @JvmOverloads
    constructor(value: String, magnitude: Magnitude = NATURAL)
            : super(value, magnitude, CADUnit)

    // region UnitAmount

    override fun plus(currency: UnitAmount<CurrencyUnit>) =
        CAD(this.amount + (currency to CADUnit).amount)

    override fun minus(currency: UnitAmount<CurrencyUnit>) =
        CAD(this.amount - (currency to CADUnit).amount)

    override fun times(scalar: Number) =
        CAD(this.amount * scalar)

    override fun div(scalar: Number) =
        CAD(this.amount / scalar)

    // endregion
}
