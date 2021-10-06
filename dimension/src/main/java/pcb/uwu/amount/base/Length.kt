package pcb.uwu.amount.base

import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.amount.derived.mechanics.Speed
import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.util.UnitAmountUtils

open class Length : CompositeUnitAmount<LengthUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LengthUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(length: UnitAmount<LengthUnit>) =
        Length(amount = this.amount + (length to this.unit).amount,
               unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(length: UnitAmount<LengthUnit>) =
        Length(amount = this.amount - (length to this.unit).amount,
               unit = this.unit)

    override fun times(scalar: Number) =
        Length(amount = this.amount * scalar,
               unit = this.unit)

    override fun div(scalar: Number) =
        Length(amount = this.amount / scalar,
               unit = this.unit)

    override fun to(unit: LengthUnit) =
        Length(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion

    // region composition

    open operator fun div(time: Time): Speed =
        Speed(amount = this.amount / time.amount,
              unit = SpeedUnit(this.unit, time.unit))

    open operator fun div(speed: Speed) =
        Time(amount = super.div(speed).amount,
             unit = speed.unit.unitCounter.findUnit(TimeUnit::class)!!)

    open operator fun times(length: Length) =
        Area(amount = amount * length.amount,
             unit = AreaUnit(this.unit, length.unit))

    open operator fun times(force: Force) =
        Energy(amount = amount * force.amount,
               unit = EnergyUnit(lengthUnit = this.unit, forceUnit = force.unit))

    // endregion
}
