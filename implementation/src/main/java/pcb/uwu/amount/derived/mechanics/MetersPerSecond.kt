package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit

class MetersPerSecond : Speed
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MeterPerSecondUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, MeterPerSecondUnit)

    // region UnitAmount

    override fun plus(speed: UnitAmount<SpeedUnit>) =
        MetersPerSecond(this.amount + (speed to MeterPerSecondUnit).amount)

    override fun minus(speed: UnitAmount<SpeedUnit>) =
        MetersPerSecond(this.amount - (speed to MeterPerSecondUnit).amount)

    override fun times(scalar: Number) =
        MetersPerSecond(this.amount * scalar)

    override fun div(scalar: Number) =
        MetersPerSecond(this.amount / scalar)

    // endregion

    // region composition

    override fun times(time: Time) =
        Meters(this.amount * (time to SecondUnit).amount)

    override fun div(time: Time) =
        MetersPerSquareSecond(this.amount / (time to SecondUnit).amount)

    override fun div(acceleration: Acceleration) =
        Seconds(this.amount / (acceleration to AccelerationUnit(MeterPerSecondUnit, SecondUnit)).amount)

    // endregion

    companion object
    {
        // region constants
        val SPEED_OF_LIGHT: Speed = MetersPerSecond("299792458")
    }
}