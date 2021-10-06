package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CelsiusUnit
import pcb.uwu.unit.base.TemperatureUnit

class Celsius : Temperature
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CelsiusUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CelsiusUnit)

    // region UnitAmount

    override fun plus(temperature: UnitAmount<TemperatureUnit>) =
        Celsius(this.amount + (temperature to CelsiusUnit).amount)

    override fun minus(temperature: UnitAmount<TemperatureUnit>) =
        Celsius(this.amount + (temperature to CelsiusUnit).amount)

    override fun times(scalar: Number) =
        Celsius(this.amount * scalar)

    override fun div(scalar: Number) =
        Celsius(this.amount / scalar)

    // endregion
}
