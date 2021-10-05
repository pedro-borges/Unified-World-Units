package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmountOfSubstanceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class AmountOfSubstance : CompositeUnitAmount<AmountOfSubstanceUnit>
{
    @JvmOverloads
    constructor(value: Number,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(value, magnitude, unit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(value, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(value = this.amount + other.into(this.unit).amount,
                          unit = this.unit)

    override operator fun minus(other: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(value = this.amount - other.into(this.unit).amount,
                          unit = this.unit)

    override fun multiply(other: BigDecimal, mathContext: MathContext) =
        AmountOfSubstance(value = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                          unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        AmountOfSubstance(value = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                          unit = this.unit)

    override fun into(unit: AmountOfSubstanceUnit) =
        AmountOfSubstance(value = UnitAmountUtils.getAmountIn(this, unit),
                          unit = this.unit)

    // endregion
}