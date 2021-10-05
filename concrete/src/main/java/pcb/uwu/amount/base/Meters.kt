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

    override operator fun plus(other: UnitAmount<LengthUnit>) =
        Meters(this.amount + other.into(METER).amount)

    override operator fun minus(other: UnitAmount<LengthUnit>) =
        Meters(this.amount - other.into(METER).amount)

    override operator fun times(other: Number) =
        Meters(this.amount * other)

    override operator fun div(other: Number) =
        Meters(this.amount / other)

    // endregion

    // region composition

    override operator fun times(length: Length) =
        SquareMeters(this.amount * length.into(METER).amount)

    override operator fun times(force: Force) =
        Joules(this.amount * force.into(NEWTON).amount)

    // endregion
}