package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Mass
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.amount.derived.thermodynamics.Pressure
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit
import pcb.uwu.util.UnitAmountUtils

open class Force : CompositeUnitAmount<ForceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ForceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ForceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(force: UnitAmount<ForceUnit>) =
        Force(amount = this.amount + (force to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(force: UnitAmount<ForceUnit>) =
        Force(amount = this.amount - (force to this.unit).amount,
              unit = this.unit)

    override fun times(scalar: Number) =
        Force(amount = this.amount * scalar,
              unit = this.unit)

    override fun div(scalar: Number) =
        Force(amount = this.amount / scalar,
              unit = this.unit)

    override fun to(unit: ForceUnit) =
        Force(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion

    // region composition

    operator fun div(mass: Mass) =
        Acceleration(amount = this.amount / mass.amount,
                     unit = AccelerationUnit(forceUnit = this.unit,
                                             massUnit = mass.unit))

    open operator fun times(length: Length) =
        Energy(amount = this.amount * length.amount,
               unit = EnergyUnit(forceUnit = this.unit,
                                 lengthUnit = length.unit))

    open operator fun div(pressure: Pressure) =
        Area(amount = this.amount / pressure.amount,
             unit = AreaUnit(forceUnit = this.unit,
                             pressureUnit = pressure.unit))

    open operator fun div(area: Area) =
        Pressure(amount = this.amount / area.amount,
                 unit = PressureUnit(forceUnit = this.unit,
                                     areaUnit = area.unit))

    // endregion
}