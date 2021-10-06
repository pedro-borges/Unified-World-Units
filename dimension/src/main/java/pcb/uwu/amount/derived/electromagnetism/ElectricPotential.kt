package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.util.UnitAmountUtils

open class ElectricPotential : CompositeUnitAmount<ElectricPotentialUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricPotentialUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricPotentialUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        ElectricPotential(amount = this.amount + (electricPotential to this.unit).amount,
                          unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricPotential: UnitAmount<ElectricPotentialUnit>) =
        ElectricPotential(amount = this.amount - (electricPotential to this.unit).amount,
                          unit = this.unit)

    override fun times(scalar: Number): ElectricPotential =
        ElectricPotential(amount = this.amount * scalar,
                          unit = this.unit)

    override fun div(scalar: Number) =
        ElectricPotential(amount = this.amount / scalar,
                          unit = this.unit)

    override fun to(unit: ElectricPotentialUnit) =
        ElectricPotential(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion

    // region composition

    open operator fun div(electricCurrent: ElectricCurrent) =
        ElectricResistance(amount = this.amount / electricCurrent.amount,
                           unit = ElectricResistanceUnit(electricPotentialUnit = this.unit,
                                                         electricCurrentUnit = electricCurrent.unit))

    open operator fun times(electricCharge: ElectricCharge) =
        Energy(amount = this.amount * electricCharge.amount,
               unit = EnergyUnit(electricPotentialUnit = this.unit,
                                 electricChargeUnit = electricCharge.unit))

    // endregion
}
