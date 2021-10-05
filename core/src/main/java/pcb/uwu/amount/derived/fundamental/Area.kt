package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Length
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

open class Area : CompositeUnitAmount<AreaUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AreaUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AreaUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<AreaUnit>) =
        Area(amount = this.amount + (amount to this.unit).amount,
             unit = this.unit)

    override fun minus(amount: UnitAmount<AreaUnit>) =
        Area(amount = this.amount - (amount to this.unit).amount,
             unit = this.unit)

    override fun times(number: Number) =
        Area(amount = this.amount * number,
             unit = this.unit)

    override fun div(number: Number) =
        Area(amount = this.amount / number,
             unit = this.unit)

    override fun to(unit: AreaUnit) =
        Area(amount = getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    operator fun times(length: Length) =
        Volume(amount = this.amount * length.amount,
               unit = VolumeUnit(unit, length.unit))

    // endregion
}