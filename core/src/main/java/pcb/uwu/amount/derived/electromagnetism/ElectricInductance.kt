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
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricInductanceUnit)
            : super(value, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(value = this.amount + other.into(this.unit).amount,
                           unit = this.unit)

    override operator fun minus(other: UnitAmount<ElectricInductanceUnit>) =
        ElectricInductance(value = this.amount - other.into(this.unit).amount,
                           unit = this.unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        ElectricInductance(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                           unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        ElectricInductance(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                           unit = this.unit)

    override fun into(unit: ElectricInductanceUnit) =
        ElectricInductance(value = UnitAmountUtils.getAmountIn(this, unit),
                           unit = this.unit)

    // endregion
}