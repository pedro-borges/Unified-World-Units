package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit
import pcb.uwu.util.UnitAmountUtils

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

    override fun times(scalar: Number) =
        Pressure(amount = this.amount * scalar,
                 unit = this.unit)

    override fun div(scalar: Number) =
        Pressure(amount = this.amount / scalar,
                 unit = this.unit)

    override fun to(unit: PressureUnit) =
        Pressure(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                 unit = unit)

    // endregion

    // region composition


    open operator fun times(volume: Volume) =
        Energy(amount = this.amount * volume.amount,
               unit = EnergyUnit(pressureUnit = this.unit,
                                 volumeUnit = volume.unit))

    open operator fun times(area: Area) =
        Force(amount = this.amount * area.amount,
              unit = ForceUnit(pressureUnit = this.unit,
                               areaUnit = area.unit))

    // endregion
}