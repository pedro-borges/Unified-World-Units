package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.IlluminanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class Illuminance : CompositeUnitAmount<IlluminanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount + (amount to this.unit).amount,
                    unit = this.unit)

    override fun minus(amount: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount - (amount to this.unit).amount,
                    unit = this.unit)

    override fun times(number: Number) =
        Illuminance(amount = this.amount * number,
                    unit = this.unit)

    override fun div(number: Number) =
        Illuminance(amount = this.amount / number,
                    unit = this.unit)

    override fun to(unit: IlluminanceUnit) =
        Illuminance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                    unit = unit)

    // endregion
}