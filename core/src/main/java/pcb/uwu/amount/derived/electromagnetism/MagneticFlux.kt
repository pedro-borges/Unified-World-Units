package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.utils.UnitAmountUtils

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

    override fun plus(amount: UnitAmount<MagneticFluxUnit>) =
        MagneticFlux(amount = this.amount + (amount to this.unit).amount,
                     unit = this.unit)

    override fun minus(amount: UnitAmount<MagneticFluxUnit>) =
        MagneticFlux(amount = this.amount - (amount to this.unit).amount,
                     unit = this.unit)

    override fun times(number: Number) =
        MagneticFlux(amount = this.amount * number,
                     unit = this.unit)

    override fun div(number: Number) =
        MagneticFlux(amount = this.amount / number,
                     unit = this.unit)

    override fun to(unit: MagneticFluxUnit) =
        MagneticFlux(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                     unit = unit)

    // endregion
}