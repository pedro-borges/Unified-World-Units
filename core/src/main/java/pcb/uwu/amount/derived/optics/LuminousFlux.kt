package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.LuminousFluxUnit
import pcb.uwu.utils.UnitAmountUtils

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

    override operator fun plus(other: UnitAmount<LuminousFluxUnit>) =
        LuminousFlux(amount = this.amount + other.into(this.unit).amount,
                     unit = this.unit)

    override operator fun minus(other: UnitAmount<LuminousFluxUnit>) =
        LuminousFlux(amount = this.amount - other.into(this.unit).amount,
                     unit = this.unit)

    override operator fun times(other: Number) =
        LuminousFlux(amount = this.amount * other,
                     unit = this.unit)

    override operator fun div(other: Number) =
        LuminousFlux(amount = this.amount / other,
                     unit = this.unit)

    override fun into(unit: LuminousFluxUnit) =
        LuminousFlux(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion
}