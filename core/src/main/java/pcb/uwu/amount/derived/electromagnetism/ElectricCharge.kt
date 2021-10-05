package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class ElectricCharge : CompositeUnitAmount<ElectricChargeUnit>
{
    @JvmOverloads
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricChargeUnit)
            : super(value, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(value = this.amount + other.into(this.unit).amount,
                       unit = this.unit)

    override operator fun minus(other: UnitAmount<ElectricChargeUnit>) =
        ElectricCharge(value = amount - other.into(unit).amount,
                       unit = this.unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        ElectricCharge(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                       unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        ElectricCharge(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                       unit = this.unit)

    override fun into(unit: ElectricChargeUnit) =
        ElectricCharge(value = UnitAmountUtils.getAmountIn(this, unit),
                       unit = this.unit)

    // endregion
}