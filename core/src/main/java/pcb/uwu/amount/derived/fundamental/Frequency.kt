package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.FrequencyUnit
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

open class Frequency : CompositeUnitAmount<FrequencyUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: FrequencyUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: FrequencyUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<FrequencyUnit>) =
        Frequency(amount = this.amount + other.into(this.unit).amount,
                  unit = this.unit)

    override operator fun minus(other: UnitAmount<FrequencyUnit>) =
        Frequency(amount = this.amount - other.into(this.unit).amount,
                  unit = this.unit)

    override operator fun times(other: Number) =
        Frequency(amount = this.amount * other,
                  unit = this.unit)

    override operator fun div(other: Number) =
        Frequency(amount = this.amount / other,
                  unit = this.unit)

    override fun into(unit: FrequencyUnit) =
        Frequency(amount = getAmountIn(unitAmount = this, newUnit = unit),
                  unit = unit)

    override fun invert() =
        Time(amount = amount.invert(),
             unit = unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    // endregion
}