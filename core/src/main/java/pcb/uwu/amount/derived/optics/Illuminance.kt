package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.IlluminanceUnit
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.util.UnitAmountUtils

open class Illuminance : CompositeUnitAmount<IlluminanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(illuminance: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount + (illuminance to this.unit).amount,
                    unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(illuminance: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount - (illuminance to this.unit).amount,
                    unit = this.unit)

    override fun times(scalar: Number) =
        Illuminance(amount = this.amount * scalar,
                    unit = this.unit)

    override fun div(scalar: Number) =
        Illuminance(amount = this.amount / scalar,
                    unit = this.unit)

    override fun to(unit: IlluminanceUnit) =
        Illuminance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                    unit = unit)

    // endregion

    // region composition

    open operator fun times(area: Area) =
        LuminousFlux(amount = this.amount * area.amount,
                     unit = LuminousFluxUnit(illuminanceUnit = this.unit,
                                             areaUnit = area.unit))

    // endregion

}