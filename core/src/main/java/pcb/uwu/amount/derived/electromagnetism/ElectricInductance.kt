package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class ElectricInductance : CompositeUnitAmount<ElectricInductanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(amount = this.amount + other.into(this.unit).amount,
                           unit = this.unit)

    override operator fun minus(other: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(amount = this.amount - other.into(this.unit).amount,
                           unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        ElectricInductance(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                           unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        ElectricInductance(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                           unit = this.unit)

    override fun into(unit: ElectricInductanceUnit) =
        ElectricInductance(amount = UnitAmountUtils.getAmountIn(this, unit),
                           unit = unit)

    // endregion
}