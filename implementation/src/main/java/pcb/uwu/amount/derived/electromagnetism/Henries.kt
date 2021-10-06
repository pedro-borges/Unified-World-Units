package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit
import pcb.uwu.unit.derived.electromagnetism.HenryUnit

class Henries : ElectricInductance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HenryUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, HenryUnit)

    // region UnitAmount

    override fun plus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        Henries(this.amount + (electricInductance to HenryUnit).amount)

    override fun minus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        Henries(this.amount - (electricInductance to HenryUnit).amount)

    override fun times(scalar: Number) =
        Henries(this.amount * scalar)

    override fun div(scalar: Number) =
        Henries(this.amount / scalar)

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent) =
        Webbers(this.amount * (electricCurrent to AmpereUnit).amount)

    // endregion
}
