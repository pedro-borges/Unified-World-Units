package pcb.uwu.amount.base

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.KelvinUnit.KELVIN
import pcb.uwu.unit.base.TemperatureUnit

class Kelvins : Temperature
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, KELVIN)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, KELVIN)

    // region UnitAmount

    override fun plus(temperature: UnitAmount<TemperatureUnit>): Kelvins
    {
        return Kelvins(this.amount + (temperature to KELVIN).amount)
    }

    override fun minus(temperature: UnitAmount<TemperatureUnit>): Kelvins
    {
        return Kelvins(this.amount - (temperature to KELVIN).amount)
    }

    override fun times(number: Number): Kelvins
    {
        return Kelvins(this.amount * number)
    }

    override fun div(number: Number): Kelvins
    {
        return Kelvins(this.amount / number)
    }

    // endregion
}