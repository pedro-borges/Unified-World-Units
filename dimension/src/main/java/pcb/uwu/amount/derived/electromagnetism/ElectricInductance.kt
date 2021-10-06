package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.util.UnitAmountUtils

open class ElectricInductance : CompositeUnitAmount<ElectricInductanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(amount = this.amount + (electricInductance to this.unit).amount,
                           unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(electricInductance: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(amount = this.amount - (electricInductance to this.unit).amount,
                           unit = this.unit)

    override fun times(scalar: Number) =
        ElectricInductance(amount = this.amount * scalar,
                           unit = this.unit)

    override fun div(scalar: Number) =
        ElectricInductance(amount = this.amount / scalar,
                           unit = this.unit)

    override fun to(unit: ElectricInductanceUnit) =
        ElectricInductance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                           unit = unit)

    // endregion

    // region composition

    open operator fun times(electricCurrent: ElectricCurrent) =
        MagneticFlux(amount = this.amount * electricCurrent.amount,
                     unit = MagneticFluxUnit(electricInductanceUnit = this.unit,
                                             electricCurrentUnit = electricCurrent.unit))

    // endregion
}
