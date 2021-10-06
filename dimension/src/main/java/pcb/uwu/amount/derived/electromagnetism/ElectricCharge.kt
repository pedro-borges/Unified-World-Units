package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.util.UnitAmountUtils

open class ElectricCharge : CompositeUnitAmount<ElectricChargeUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricCharge: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(amount = this.amount + (electricCharge to this.unit).amount,
                       unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricCharge: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(amount = this.amount - (electricCharge to unit).amount,
                       unit = this.unit)

    override fun times(scalar: Number) =
        ElectricCharge(amount = this.amount * scalar,
                       unit = this.unit)

    override fun div(scalar: Number) =
        ElectricCharge(amount = this.amount / scalar,
                       unit = this.unit)

    override fun to(unit: ElectricChargeUnit) =
        ElectricCharge(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                       unit = unit)

    // endregion

    // region composition

    open operator fun div(electricCapacitance: ElectricCapacitance) =
        ElectricPotential(amount = this.amount / electricCapacitance.amount,
                          unit = ElectricPotentialUnit(electricChargeUnit = this.unit,
                                                       electricCapacitanceUnit = electricCapacitance.unit))

    open operator fun div(electricPotential: ElectricPotential) =
        ElectricCapacitance(amount = this.amount / electricPotential.amount,
                            unit = ElectricCapacitanceUnit(electricChargeUnit = this.unit,
                                                           electricPotentialUnit = electricPotential.unit))

    open operator fun times(electricPotential: ElectricPotential) =
        Energy(amount = this.amount * electricPotential.amount,
               unit = EnergyUnit(electricChargeUnit = this.unit,
                                 electricPotentialUnit = electricPotential.unit))

    // endregion
}
