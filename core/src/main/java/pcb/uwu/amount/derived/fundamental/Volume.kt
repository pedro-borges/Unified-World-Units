package pcb.uwu.amount.derived.fundamental

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.utils.UnitAmountUtils.dividedByScalar
import pcb.uwu.utils.UnitAmountUtils.getAmountIn
import pcb.uwu.utils.UnitAmountUtils.multipliedByScalar
import java.math.BigDecimal
import java.math.MathContext

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

    override operator fun plus(other: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount + other.into(this.unit).amount,
               unit = this.unit)

    override operator fun minus(other: UnitAmount<VolumeUnit>) =
        Volume(amount = this.amount - other.into(this.unit).amount,
               unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Volume(amount = multipliedByScalar(this, other, mathContext),
               unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Volume(amount = dividedByScalar(this, other, mathContext),
               unit = this.unit)

    override fun into(unit: VolumeUnit) =
        Volume(amount = getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion
}