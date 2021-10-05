package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.mechanics.Newtons
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER
import pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL
import pcb.uwu.unit.derived.termodynamics.PressureUnit

class Pascals : Pressure
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PASCAL)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PASCAL)

    // region implement UnitAmount
    override fun plus(pressure: UnitAmount<PressureUnit>) =
        Pascals(this.amount + (pressure to PASCAL).amount)

    override fun minus(pressure: UnitAmount<PressureUnit>) =
        Pascals(this.amount - (pressure to PASCAL).amount)


    override fun times(scalar: Number) =
        Pascals(this.amount * scalar)

    override fun div(scalar: Number) =
        Pascals(this.amount / scalar)

    // endregion

    // region composition

    override fun times(volume: Volume) =
        Joules(this.amount * (volume to CUBIC_METER).amount)

    override fun times(area: Area) =
        Newtons(this.amount * (area to SQUARE_METER).amount)

    // endregion
}