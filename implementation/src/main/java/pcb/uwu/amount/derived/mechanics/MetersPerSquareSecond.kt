package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Mass
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSquareSecondUnit

class MetersPerSquareSecond : Acceleration
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MeterPerSquareSecondUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MeterPerSquareSecondUnit)

    // region UnitAmount

    override fun plus(acceleration: UnitAmount<AccelerationUnit>) =
        MetersPerSquareSecond(this.amount + (acceleration to MeterPerSquareSecondUnit).amount)

    override fun minus(acceleration: UnitAmount<AccelerationUnit>) =
        MetersPerSquareSecond(this.amount - (acceleration to MeterPerSquareSecondUnit).amount)

    override fun times(scalar: Number) =
        MetersPerSquareSecond(this.amount * scalar)

    override fun div(scalar: Number) =
        MetersPerSquareSecond(this.amount / scalar)

    // endregion

    // region composition

    override fun times(mass: Mass) =
        Newtons(this.amount * mass.amount)

    override fun times(time: Time) =
        MetersPerSecond(this.amount * (time to SecondUnit).amount)

    override fun times(speed: Speed) =
        Seconds(this.amount / (speed to MeterPerSecondUnit).amount)

    // endregion
}
