package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.electromagnetism.ElectricCharge
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PowerUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit
import pcb.uwu.util.UnitAmountUtils

open class Energy : CompositeUnitAmount<EnergyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: EnergyUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: EnergyUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(energy: UnitAmount<EnergyUnit>) =
        Energy(amount = this.amount + (energy to this.unit).amount,
               unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(energy: UnitAmount<EnergyUnit>) =
        Energy(amount = this.amount - (energy to this.unit).amount,
               unit = this.unit)

    override fun times(scalar: Number) =
        Energy(amount = this.amount * scalar,
               unit = this.unit)

    override fun div(scalar: Number) =
        Energy(amount = this.amount / scalar,
               unit = this.unit)

    override fun to(unit: EnergyUnit) =
        Energy(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
               unit = unit)

    // endregion

    // region composition

    open operator fun div(volume: Volume) =
        Pressure(amount = this.amount / volume.amount,
                 unit = PressureUnit(energyUnit = this.unit,
                                     volumeUnit = volume.unit))

    open operator fun div(pressure: Pressure) =
        Volume(amount = this.amount / pressure.amount,
               unit = VolumeUnit(energyUnit = this.unit,
                                 pressureUnit = pressure.unit))

    open operator fun div(time: Time) =
        Power(amount = this.amount / time.amount,
              unit = PowerUnit(energyUnit = this.unit,
                               timeUnit = time.unit))

    open operator fun div(length: Length) =
        Force(amount = this.amount / length.amount,
              unit = ForceUnit(energyUnit = this.unit,
                               lengthUnit = length.unit))

    open operator fun div(electricCharge: ElectricCharge) =
        ElectricPotential(amount = this.amount / electricCharge.amount,
                          unit = ElectricPotentialUnit(energyUnit = this.unit,
                                                       electricChargeUnit = electricCharge.unit))

    open operator fun div(electricPotential: ElectricPotential) =
        ElectricCharge(amount = this.amount / electricPotential.amount,
                       unit = ElectricChargeUnit(energyUnit = this.unit,
                                                 electricPotentialUnit = electricPotential.unit))

    // endregion
}