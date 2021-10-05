package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import pcb.uwu.unit.derived.mechanics.PaceUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Speed : CompositeUnitAmount<SpeedUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: SpeedUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: SpeedUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<SpeedUnit>) =
        Speed(amount = this.amount + other.into(this.unit).amount,
              unit = this.unit)

    override operator fun minus(other: UnitAmount<SpeedUnit>) =
        Speed(amount = this.amount - other.into(this.unit).amount,
              unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Speed(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Speed(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
              unit = this.unit)

    override fun into(unit: SpeedUnit) =
        Speed(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    override fun invert(mathContext: MathContext) =
        Pace(amount = this.amount.invert(mathContext),
             unit = PaceUnit(this.unit))

    // endregion

    // region composition

    fun div(time: Time, mathContext: MathContext) =
        Acceleration(amount = this.amount.div(time.amount.value, mathContext),
                     unit = AccelerationUnit(this.unit, time.unit))

    open fun div(acceleration: Acceleration, mathContext: MathContext) =
        Time(amount = super.div(acceleration, mathContext).amount,
             unit = this.unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    open fun times(time: Time, mathContext: MathContext) =
        Length(amount = super.times(time, mathContext).amount,
               unit = this.unit.unitCounter.findUnit(LengthUnit::class.java)!!)

    // endregion
}