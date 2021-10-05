package pcb.uwu.amount.base

import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.optics.Luminance
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.amount.derived.scalar.SolidAngle
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.optics.LuminanceUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.util.UnitAmountUtils

open class LuminousIntensity : CompositeUnitAmount<LuminousIntensityUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminousIntensityUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount + (luminousIntensity to this.unit).amount,
                          unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(luminousIntensity: UnitAmount<LuminousIntensityUnit>) =
        LuminousIntensity(amount = this.amount - (luminousIntensity to this.unit).amount,
                          unit = this.unit)

    override fun times(scalar: Number) =
        LuminousIntensity(amount = this.amount * scalar,
                          unit = this.unit)

    override fun div(scalar: Number) =
        LuminousIntensity(amount = this.amount / scalar,
                          unit = this.unit)

    override fun to(unit: LuminousIntensityUnit) =
        LuminousIntensity(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion

    // region composition


    open operator fun times(solidAngle: SolidAngle) =
        LuminousFlux(amount = this.amount * solidAngle.amount,
                     unit = LuminousFluxUnit(this.unit, solidAngle.unit))

    open operator fun div(area: Area) =
        Luminance(amount = this.amount / area.amount,
                  unit = LuminanceUnit(this.unit, area.unit))

    open operator fun div(luminance: Luminance) =
        Area(amount = this.amount / luminance.amount,
             unit = AreaUnit(this.unit, luminance.unit))

    // endregion
}