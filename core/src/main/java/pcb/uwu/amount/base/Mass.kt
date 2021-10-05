package pcb.uwu.amount.base

import pcb.uwu.amount.derived.mechanics.Acceleration
import pcb.uwu.amount.derived.mechanics.Force
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Mass : CompositeUnitAmount<MassUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: MassUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<MassUnit>) =
        Mass(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<MassUnit>) =
        Mass(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Mass(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Mass(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun into(unit: MassUnit) =
        Mass(amount = UnitAmountUtils.getAmountIn(this, unit),
             unit = unit)

    // endregion

    // region composition

    fun multipliedBy(acceleration: Acceleration, mathContext: MathContext) =
        Force(amount = this.amount.times(acceleration.amount.value, mathContext),
              unit = ForceUnit(this.unit, acceleration.unit))

    // endregion
}