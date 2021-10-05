package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.PermillageUnit
import pcb.uwu.unit.base.ScalarUnit

class Permillage : Scalar
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PermillageUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, PermillageUnit)

    // region UnitAmount

    override fun plus(scalar: UnitAmount<ScalarUnit>) =
        Permillage(this.amount + (scalar to PermillageUnit).amount)

    override fun minus(scalar: UnitAmount<ScalarUnit>) =
        Permillage(this.amount + (scalar to PermillageUnit).amount)

    override fun times(scalar: Number) =
        Permillage(this.amount * scalar)

    override fun div(scalar: Number) =
        Permillage(this.amount / scalar)

    // endregion
}