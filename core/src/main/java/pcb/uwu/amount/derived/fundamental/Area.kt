package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.optics.Illuminance
import pcb.uwu.amount.derived.optics.LuminousFlux
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.util.UnitAmountUtils.getAmountIn

open class Area : CompositeUnitAmount<AreaUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AreaUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AreaUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(area: UnitAmount<AreaUnit>) =
        Area(amount = this.amount + (area to this.unit).amount,
             unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(area: UnitAmount<AreaUnit>) =
        Area(amount = this.amount - (area to this.unit).amount,
             unit = this.unit)

    override fun times(scalar: Number) =
        Area(amount = this.amount * scalar,
             unit = this.unit)

    override fun div(scalar: Number) =
        Area(amount = this.amount / scalar,
             unit = this.unit)

    override fun to(unit: AreaUnit) =
        Area(amount = getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    // endregion

    // region composition

    open operator fun times(length: Length) =
        Volume(amount = this.amount * length.amount,
               unit = VolumeUnit(areaUnit = this.unit,
                                 sizeUnit = length.unit))

    open operator fun times(illuminance: Illuminance) =
        LuminousFlux(amount = this.amount * illuminance.amount,
                     unit = LuminousFluxUnit(areaUnit = this.unit,
                                             illuminanceUnit = illuminance.unit))

    // endregion
}