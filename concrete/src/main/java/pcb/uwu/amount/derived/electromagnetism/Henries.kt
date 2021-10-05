package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit
import pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY

class Henries : ElectricInductance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HENRY)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HENRY)

    // region UnitAmount

    override fun plus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        Henries(this.amount + (electricInductance to HENRY).amount)

    override fun minus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        Henries(this.amount - (electricInductance to HENRY).amount)

    override fun times(scalar: Number) =
        Henries(this.amount * scalar)

    override fun div(scalar: Number) =
        Henries(this.amount / scalar)

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent): Webbers
    {
        return Webbers(this.amount * (electricCurrent to AMPERE).amount)
    }

    // endregion
}