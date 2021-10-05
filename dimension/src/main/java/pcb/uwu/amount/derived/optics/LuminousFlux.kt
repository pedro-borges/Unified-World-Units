package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.LuminousIntensity
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.scalar.SolidAngle
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.geometry.SolidAngleUnit
import pcb.uwu.unit.derived.optics.IlluminanceUnit
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.util.UnitAmountUtils

open class LuminousFlux : CompositeUnitAmount<LuminousFluxUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: LuminousFluxUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: LuminousFluxUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(luminousFlux: UnitAmount<LuminousFluxUnit>) =
        LuminousFlux(amount = this.amount + (luminousFlux to this.unit).amount,
                     unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(luminousFlux: UnitAmount<LuminousFluxUnit>) =
        LuminousFlux(amount = this.amount - (luminousFlux to this.unit).amount,
                     unit = this.unit)

    override fun times(scalar: Number) =
        LuminousFlux(amount = this.amount * scalar,
                     unit = this.unit)

    override fun div(scalar: Number) =
        LuminousFlux(amount = this.amount / scalar,
                     unit = this.unit)

    override fun to(unit: LuminousFluxUnit) =
        LuminousFlux(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion

    // region composition

    open operator fun div(luminousIntensity: LuminousIntensity) =
        SolidAngle(amount = this.amount / luminousIntensity.amount,
                   unit = SolidAngleUnit(luminousFluxUnit = this.unit,
                                         luminousIntensityUnit = luminousIntensity.unit))

    open operator fun times(time: Time) =
        LuminousEnergy(amount = this.amount * time.amount,
                       unit = LuminousEnergyUnit(luminousFluxUnit = this.unit,
                                                 timeUnit = time.unit))

    open operator fun div(area: Area) =
        Illuminance(amount = this.amount / area.amount,
                    unit = IlluminanceUnit(luminousFluxUnit = this.unit,
                                           areaUnit = area.unit))

    open operator fun div(illuminance: Illuminance) =
        Area(amount = this.amount / illuminance.amount,
             unit = AreaUnit(luminousFluxUnit = this.unit,
                             illuminanceUnit = illuminance.unit))

    // endregion
}