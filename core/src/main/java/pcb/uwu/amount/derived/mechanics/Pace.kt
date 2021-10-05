package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.mechanics.PaceUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

class Pace : CompositeUnitAmount<PaceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: PaceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: PaceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<PaceUnit>) =
        Pace(amount = this.amount + other.into(this.unit).amount,
             unit = this.unit)

    override operator fun minus(other: UnitAmount<PaceUnit>) =
        Pace(amount = this.amount - other.into(this.unit).amount,
             unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Pace(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Pace(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
             unit = this.unit)

    override fun into(unit: PaceUnit) =
        Pace(amount = UnitAmountUtils.getAmountIn(this, unit),
             unit = this.unit)

    override fun invert(mathContext: MathContext) =
        Speed(amount = amount.invert(mathContext),
              unit = SpeedUnit(unit))

    // endregion

    // region composition

    fun times(length: Length, mathContext: MathContext) =
        Time(amount = super.times(length, mathContext).amount,
             unit = unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    // endregion
}