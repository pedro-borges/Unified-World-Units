package pcb.uwu.amount.derived.geometry

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.geometry.VolumeUnit
import pcb.uwu.util.UnitAmountUtils.getAmountIn

open class Volume : CompositeUnitAmount<VolumeUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: VolumeUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: VolumeUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(volume: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount + (volume to this.unit).amount,
               unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(volume: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount - (volume to this.unit).amount,
               unit = this.unit)

    override fun times(scalar: Number) =
        Volume(amount = this.amount * scalar,
               unit = this.unit)

    override fun div(scalar: Number) =
        Volume(amount = this.amount / scalar,
               unit = this.unit)

    override fun to(unit: VolumeUnit) =
        Volume(amount = getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion
}