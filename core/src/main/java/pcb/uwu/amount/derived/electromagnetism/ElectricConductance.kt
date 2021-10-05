package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.util.UnitAmountUtils

open class ElectricConductance : CompositeUnitAmount<ElectricConductanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricConductanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricConductanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricConductance: UnitAmount<ElectricConductanceUnit>) =
        ElectricConductance(amount = this.amount + (electricConductance to this.unit).amount,
                            unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricConductance: UnitAmount<ElectricConductanceUnit>) =
        ElectricConductance(amount = this.amount - (electricConductance to this.unit).amount,
                            unit = this.unit)

    override fun times(scalar: Number) =
        ElectricConductance(amount = this.amount * scalar,
                            unit = this.unit)

    override fun div(scalar: Number) =
        ElectricConductance(amount = this.amount / scalar,
                            unit = this.unit)

    override fun to(unit: ElectricConductanceUnit) =
        ElectricConductance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                            unit = unit)

    // endregion

    // region composition

    open operator fun times(electricCurrent: ElectricCurrent) =
        ElectricPotential(amount = this.amount * electricCurrent.amount,
                          unit = ElectricPotentialUnit(electricConductanceUnit = this.unit,
                                                       electricCurrentUnit = electricCurrent.unit))

    // endregion
}