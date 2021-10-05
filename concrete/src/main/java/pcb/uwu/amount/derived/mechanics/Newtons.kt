package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.KiloGrams
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.amount.derived.thermodynamics.Pascals
import pcb.uwu.amount.derived.thermodynamics.Pressure
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.mechanics.NewtonUnit
import pcb.uwu.unit.derived.termodynamics.PascalUnit

class Newtons : Force
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NewtonUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, NewtonUnit)

    // region UnitAmount

    override fun plus(force: UnitAmount<ForceUnit>) =
        Newtons(this.amount + (force to NewtonUnit).amount)

    override fun minus(force: UnitAmount<ForceUnit>) =
        Newtons(this.amount - (force to NewtonUnit).amount)

    override fun times(scalar: Number) =
        Newtons(this.amount * scalar)

    override fun div(scalar: Number) =
        Newtons(this.amount / scalar)

    // endregion

    // region composition

    operator fun div(acceleration: Acceleration) =
        KiloGrams(super.div(acceleration).amount)

    override fun times(length: Length) =
        Joules(this.amount * (length to MeterUnit).amount)

    override fun div(pressure: Pressure) =
        SquareMeters(this.amount / (pressure to PascalUnit).amount)

    override fun div(area: Area) =
        Pascals(this.amount / (area to SquareMeterUnit).amount)

    // endregion
}