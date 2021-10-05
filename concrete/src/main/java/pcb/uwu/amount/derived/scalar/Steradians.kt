package pcb.uwu.amount.derived.scalar

import pcb.uwu.amount.base.LuminousIntensity
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CandelaUnit
import pcb.uwu.unit.scalar.SolidAngleUnit
import pcb.uwu.unit.scalar.SteradianUnit

class Steradians : SolidAngle
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SteradianUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SteradianUnit)

    // region UnitAmount

    override fun plus(solidAngle: UnitAmount<SolidAngleUnit>) =
        Steradians(this.amount + (solidAngle to SteradianUnit).amount)

    override fun minus(solidAngle: UnitAmount<SolidAngleUnit>) =
        Steradians(this.amount - (solidAngle to SteradianUnit).amount)

    override fun times(scalar: Number) =
        Steradians(this.amount * scalar)

    override fun div(scalar: Number) =
        Steradians(this.amount / scalar)

    // endregion

    // region composition

    override fun times(luminousIntensity: LuminousIntensity) =
        Lumens(amount * (luminousIntensity to CandelaUnit).amount)

    // endregion
}