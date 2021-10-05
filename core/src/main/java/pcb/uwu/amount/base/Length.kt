package pcb.uwu.amount.base

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.mechanics.Speed
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Length : CompositeUnitAmount<LengthUnit>
{
    @JvmOverloads
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit) : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: BigDecimal,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(amount: BigDecimalAmount,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<LengthUnit>) =
        Length(value = amount + other.into(unit).amount,
               unit = unit)

    override operator fun minus(other: UnitAmount<LengthUnit>) =
        Length(value = amount - other.into(unit).amount,
               unit = unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        Length(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
               unit = unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Length(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
               unit = unit)

    override fun into(unit: LengthUnit) =
        Length(value = UnitAmountUtils.getAmountIn(this, unit),
               unit = unit)

    // endregion

    // region composition

    fun dividedBy(time: Time, mathContext: MathContext): Speed =
        Speed(this.amount.div(time.amount.value, mathContext), SpeedUnit(this.unit, time.unit))

    fun dividedBy(speed: Speed, mathContext: MathContext) =
        Time(value = super.div(speed, mathContext).amount,
             unit = speed.unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    fun multipliedBy(length: Length, mathContext: MathContext) =
        Area(amount.times(length.amount, mathContext),
             AreaUnit(unit, length.unit))

    // endregion
}