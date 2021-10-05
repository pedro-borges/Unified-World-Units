package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit
import pcb.uwu.unit.derived.electromagnetism.TeslaUnit

class Teslas : MagneticField
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TeslaUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, TeslaUnit)

    // region UnitAmount

    override fun plus(magneticField: UnitAmount<MagneticFieldUnit>) =
        Teslas(this.amount + (magneticField to TeslaUnit).amount)

    override fun minus(magneticField: UnitAmount<MagneticFieldUnit>) =
        Teslas(this.amount - (magneticField to TeslaUnit).amount)

    override fun times(scalar: Number) =
        Teslas(this.amount * scalar)

    override fun div(scalar: Number) =
        Teslas(this.amount / scalar)

    // endregion

    // region composition

    override fun times(area: Area) =
        Webbers(this.amount * (area to SquareMeterUnit).amount)

    // endregion
}