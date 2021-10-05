package pcb.uwu.amount.derived.fundamental

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

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

    override fun plus(amount: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount + (amount to this.unit).amount,
               unit = this.unit)

    override fun minus(amount: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount - (amount to this.unit).amount,
               unit = this.unit)

    override fun times(number: Number) =
        Volume(amount = this.amount * number,
               unit = this.unit)

    override fun div(number: Number) =
        Volume(amount = this.amount / number,
               unit = this.unit)

    override fun to(unit: VolumeUnit) =
        Volume(amount = getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion
}