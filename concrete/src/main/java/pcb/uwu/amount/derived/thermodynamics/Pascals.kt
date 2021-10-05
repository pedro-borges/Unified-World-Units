package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.geometry.Volume
import pcb.uwu.amount.derived.mechanics.Newtons
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.geometry.CubicMeterUnit
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import pcb.uwu.unit.derived.termodynamics.PascalUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit

class Pascals : Pressure
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PascalUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PascalUnit)

    // region implement UnitAmount
    override fun plus(pressure: UnitAmount<PressureUnit>) =
        Pascals(this.amount + (pressure to PascalUnit).amount)

    override fun minus(pressure: UnitAmount<PressureUnit>) =
        Pascals(this.amount - (pressure to PascalUnit).amount)


    override fun times(scalar: Number) =
        Pascals(this.amount * scalar)

    override fun div(scalar: Number) =
        Pascals(this.amount / scalar)

    // endregion

    // region composition

    override fun times(volume: Volume) =
        Joules(this.amount * (volume to CubicMeterUnit).amount)

    override fun times(area: Area) =
        Newtons(this.amount * (area to SquareMeterUnit).amount)

    // endregion
}