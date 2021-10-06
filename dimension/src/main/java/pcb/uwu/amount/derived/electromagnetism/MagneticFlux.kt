package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.thermodynamics.Energy
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.util.UnitAmountUtils

open class MagneticFlux : CompositeUnitAmount<MagneticFluxUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: MagneticFluxUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: MagneticFluxUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        MagneticFlux(amount = this.amount + (magneticFlux to this.unit).amount,
                     unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(magneticFlux: UnitAmount<MagneticFluxUnit>) =
        MagneticFlux(amount = this.amount - (magneticFlux to this.unit).amount,
                     unit = this.unit)

    override fun times(scalar: Number) =
        MagneticFlux(amount = this.amount * scalar,
                     unit = this.unit)

    override fun div(scalar: Number) =
        MagneticFlux(amount = this.amount / scalar,
                     unit = this.unit)

    override fun to(unit: MagneticFluxUnit) =
        MagneticFlux(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion

    // region composition
    open operator fun div(time: Time) =
        ElectricPotential(amount = this.amount / time.amount,
                          unit = ElectricPotentialUnit(magneticFluxUnit = this.unit,
                                                       timeUnit = time.unit))

    open operator fun div(electricCurrent: ElectricCurrent) =
        ElectricInductance(amount = this.amount / electricCurrent.amount,
                           unit = ElectricInductanceUnit(magneticFluxUnit = this.unit,
                                                         electricCurrentUnit = electricCurrent.unit))

    open operator fun div(magneticField: MagneticField) =
        Area(amount = this.amount / magneticField.amount,
             unit = AreaUnit(magneticFluxUnit = this.unit,
                             magneticFieldUnit = magneticField.unit))

    open operator fun div(area: Area) =
        MagneticField(amount = this.amount / area.amount,
                      unit = MagneticFieldUnit(magneticFluxUnit = this.unit,
                                               areaUnit = area.unit))

    open operator fun times(electricCurrent: ElectricCurrent) =
        Energy(amount = this.amount * electricCurrent.amount,
               unit = EnergyUnit(magneticFluxUnit = this.unit,
                                 electricCurrentUnit = electricCurrent.unit))

    // endregion
}
