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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(speed: UnitAmount<SpeedUnit>) =
        Speed(amount = this.amount + (speed to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(speed: UnitAmount<SpeedUnit>) =
        Speed(amount = this.amount - (speed to this.unit).amount,
              unit = this.unit)

    override fun times(scalar: Number) =
        Speed(amount = this.amount * scalar,
              unit = this.unit)

    override fun div(scalar: Number) =
        Speed(amount = this.amount / scalar,
              unit = this.unit)

    override fun to(unit: SpeedUnit) =
        Speed(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    override fun invert() =
        Pace(amount = this.amount.invert(),
             unit = PaceUnit(this.unit))

    // endregion

    // region composition

    fun div(time: Time) =
        Acceleration(amount = this.amount / time.amount,
                     unit = AccelerationUnit(this.unit, time.unit))

    open fun div(acceleration: Acceleration) =
        Time(amount = (this / acceleration).amount,
             unit = this.unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    open fun times(time: Time) =
        Length(amount = (this * time).amount,
               unit = this.unit.unitCounter.findUnit(LengthUnit::class.java)!!)

    // endregion
}