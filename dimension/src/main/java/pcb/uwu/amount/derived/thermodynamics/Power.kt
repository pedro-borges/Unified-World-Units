package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.util.UnitAmountUtils

open class Power : CompositeUnitAmount<PowerUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: PowerUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(power: UnitAmount<PowerUnit>) =
        Power(amount = this.amount + (power to this.unit).amount,
              unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(power: UnitAmount<PowerUnit>) =
        Power(amount = this.amount - (power to this.unit).amount,
              unit = this.unit)

    override fun times(scalar: Number) =
        Power(amount = this.amount * scalar,
              unit = this.unit)

    override fun div(scalar: Number) =
        Power(amount = this.amount / scalar,
              unit = this.unit)

    override fun to(unit: PowerUnit) =
        Power(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
              unit = unit)

    // endregion

    // region composition

    open operator fun times(time: Time) =
        Energy(amount = this.amount * time.amount,
               unit = EnergyUnit(powerUnit = this.unit,
                                 timeUnit = time.unit))

    open operator fun div(electricCurrent: ElectricCurrent) =
        ElectricPotential(amount = this.amount / electricCurrent.amount,
                          unit = ElectricPotentialUnit(powerUnit = this.unit,
                                                       electricCurrentUnit = electricCurrent.unit))

    // endregion
}