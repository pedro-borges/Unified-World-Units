package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class ElectricCurrent : CompositeUnitAmount<ElectricCurrentUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCurrentUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: ElectricCurrentUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount + other.into(this.unit).amount,
                        unit = this.unit)

    override operator fun minus(other: UnitAmount<ElectricCurrentUnit>) =
        ElectricCurrent(amount = this.amount - other.into(this.unit).amount,
                        unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        ElectricCurrent(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                        unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        ElectricCurrent(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                        unit = this.unit)

    override fun into(unit: ElectricCurrentUnit) =
        ElectricCurrent(amount = UnitAmountUtils.getAmountIn(this, unit),
                        unit = this.unit)

    // endregion
}