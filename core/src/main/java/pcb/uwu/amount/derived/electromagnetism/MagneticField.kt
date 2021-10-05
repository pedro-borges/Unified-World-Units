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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(magneticField: UnitAmount<MagneticFieldUnit>) =
        MagneticField(amount = this.amount + (magneticField to this.unit).amount,
                      unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(magneticField: UnitAmount<MagneticFieldUnit>) =
        MagneticField(amount = this.amount - (magneticField to this.unit).amount,
                      unit = this.unit)

    override fun times(scalar: Number) =
        MagneticField(amount = this.amount * scalar,
                      unit = this.unit)

    override fun div(scalar: Number) =
        MagneticField(amount = this.amount / scalar,
                      unit = this.unit)

    override fun to(unit: MagneticFieldUnit) =
        MagneticField(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                      unit = unit)

    // endregion
}