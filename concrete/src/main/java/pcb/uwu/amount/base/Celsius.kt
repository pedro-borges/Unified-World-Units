package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.CelsiusUnit.CELSIUS
import pcb.uwu.unit.base.TemperatureUnit

class Celsius : Temperature
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CELSIUS)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, CELSIUS)

    // region UnitAmount

    override fun plus(temperature: UnitAmount<TemperatureUnit>) =
        Celsius(this.amount + (temperature to CELSIUS).amount)

    override fun minus(temperature: UnitAmount<TemperatureUnit>) =
        Celsius(this.amount + (temperature to CELSIUS).amount)

    override fun times(number: Number) =
        Celsius(this.amount * number)

    override fun div(number: Number) =
        Celsius(this.amount / number)

    // endregion
}