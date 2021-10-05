package pcb.uwu.amount.base

import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON

class Meters : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, METER)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, METER)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Meters(this.amount + (length to METER).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Meters(this.amount - (length to METER).amount)

    override fun times(number: Number) =
        Meters(this.amount * number)

    override fun div(number: Number) =
        Meters(this.amount / number)

    // endregion

    // region composition

    override fun times(length: Length) =
        SquareMeters(this.amount * (length to METER).amount)

    override fun times(force: Force) =
        Joules(this.amount * (force to NEWTON).amount)

    // endregion
}