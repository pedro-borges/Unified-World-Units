package pcb.uwu.amount.derived.scalar

import pcb.uwu.amount.base.LuminousIntensity
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.unit.scalar.SolidAngleUnit
import pcb.uwu.utils.UnitAmountUtils

open class SolidAngle : CompositeUnitAmount<SolidAngleUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: SolidAngleUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(solidAngle: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount + (solidAngle to this.unit).amount,
                   unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(solidAngle: UnitAmount<SolidAngleUnit>) =
        SolidAngle(amount = this.amount - (solidAngle to this.unit).amount,
                   unit = this.unit)

    override fun times(scalar: Number) =
        SolidAngle(amount = this.amount * scalar,
                   unit = this.unit)

    override fun div(scalar: Number) =
        SolidAngle(amount = this.amount / scalar,
                   unit = this.unit)

    override fun to(unit: SolidAngleUnit) =
        SolidAngle(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                   unit = unit)

    // endregion

    // region composition

    open operator fun times(luminousIntensity: LuminousIntensity) =
        LuminousFlux(amount = this.amount * luminousIntensity.amount,
                     unit = LuminousFluxUnit(solidAngleUnit = this.unit,
                                             luminousIntensityUnit = luminousIntensity.unit))

    // endregion
}