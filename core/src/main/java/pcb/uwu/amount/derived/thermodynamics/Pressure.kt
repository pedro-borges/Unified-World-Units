package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.termodynamics.PressureUnit
import pcb.uwu.utils.UnitAmountUtils

open class Pressure : CompositeUnitAmount<PressureUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: PressureUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: PressureUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(pressure: UnitAmount<PressureUnit>) =
        Pressure(amount = this.amount + (pressure to this.unit).amount,
                 unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(pressure: UnitAmount<PressureUnit>) =
        Pressure(amount = this.amount - (pressure to this.unit).amount,
                 unit = this.unit)

    override fun times(number: Number) =
        Pressure(amount = this.amount * number,
                 unit = this.unit)

    override fun div(number: Number) =
        Pressure(amount = this.amount / number,
                 unit = this.unit)

    override fun to(unit: PressureUnit) =
        Pressure(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                 unit = unit)

    // endregion
}