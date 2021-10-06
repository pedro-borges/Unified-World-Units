package pcb.uwu.amount.base

import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.derived.mechanics.NewtonUnit

class Meters : Length
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MeterUnit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, MeterUnit)

    // region UnitAmount

    override fun plus(length: UnitAmount<LengthUnit>) =
        Meters(this.amount + (length to MeterUnit).amount)

    override fun minus(length: UnitAmount<LengthUnit>) =
        Meters(this.amount - (length to MeterUnit).amount)

    override fun times(scalar: Number) =
        Meters(this.amount * scalar)

    override fun div(scalar: Number) =
        Meters(this.amount / scalar)

    // endregion

    // region composition

    override fun times(length: Length) =
        SquareMeters(this.amount * (length to MeterUnit).amount)

    override fun times(force: Force) =
        Joules(this.amount * (force to NewtonUnit).amount)

    // endregion
}
