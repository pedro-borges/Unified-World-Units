package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Mass
import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import pcb.uwu.utils.UnitAmountUtils

class Acceleration : CompositeUnitAmount<AccelerationUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AccelerationUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AccelerationUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(acceleration: UnitAmount<AccelerationUnit>) =
        Acceleration(amount = this.amount + (acceleration to this.unit).amount,
                     unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(acceleration: UnitAmount<AccelerationUnit>) =
        Acceleration(amount = this.amount - (acceleration to this.unit).amount,
                     unit = this.unit)

    override fun times(number: Number) =
        Acceleration(amount = this.amount * number,
                     unit = this.unit)

    override fun div(number: Number) =
        Acceleration(amount = this.amount / number,
                     unit = this.unit)

    override fun to(unit: AccelerationUnit) =
        Acceleration(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion

    // region composition

    fun times(mass: Mass) =
        Force(amount = this.amount * mass.amount,
              unit = ForceUnit(mass.unit, this.unit))

    fun times(time: Time) =
        Speed(amount = (this * time).amount,
              unit = SpeedUnit(this.unit.unitCounter.findUnit(LengthUnit::class.java)!!,
                               this.unit.unitCounter.findUnit(TimeUnit::class.java)!!))

    // endregion
}