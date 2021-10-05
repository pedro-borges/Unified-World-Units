package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.FahrenheitUnit.FAHRENHEIT
import pcb.uwu.unit.base.TemperatureUnit

class Fahrenheits : Temperature
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FAHRENHEIT)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FAHRENHEIT)

    // region UnitAmount

    override fun plus(temperature: UnitAmount<TemperatureUnit>) =
        Fahrenheits(this.amount + (temperature to FAHRENHEIT).amount)

    override fun minus(temperature: UnitAmount<TemperatureUnit>) =
        Fahrenheits(this.amount - (temperature to FAHRENHEIT).amount)

    override fun times(scalar: Number) =
        Fahrenheits(this.amount * scalar)

    override fun div(scalar: Number) =
        Fahrenheits(this.amount / scalar)

    // endregion
}