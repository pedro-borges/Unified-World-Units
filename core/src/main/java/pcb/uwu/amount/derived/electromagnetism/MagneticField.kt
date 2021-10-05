package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit
import pcb.uwu.utils.UnitAmountUtils

open class MagneticField : CompositeUnitAmount<MagneticFieldUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: MagneticFieldUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: MagneticFieldUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override fun plus(amount: UnitAmount<MagneticFieldUnit>) =
        MagneticField(amount = this.amount + (amount to this.unit).amount,
                      unit = this.unit)

    override fun minus(amount: UnitAmount<MagneticFieldUnit>) =
        MagneticField(amount = this.amount - (amount to this.unit).amount,
                      unit = this.unit)

    override fun times(number: Number) =
        MagneticField(amount = this.amount * number,
                      unit = this.unit)

    override fun div(number: Number) =
        MagneticField(amount = this.amount / number,
                      unit = this.unit)

    override fun to(unit: MagneticFieldUnit) =
        MagneticField(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                      unit = unit)

    // endregion
}