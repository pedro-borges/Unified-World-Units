package pcb.uwu.amount.derived.acoustics

import pcb.uwu.amount.base.Time
import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.acoustics.FrequencyUnit
import pcb.uwu.util.UnitAmountUtils.getAmountIn

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

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(frequency: UnitAmount<FrequencyUnit>) =
        Frequency(amount = this.amount + (frequency to this.unit).amount,
                  unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(frequency: UnitAmount<FrequencyUnit>) =
        Frequency(amount = this.amount - (frequency to this.unit).amount,
                  unit = this.unit)

    override fun times(scalar: Number) =
        Frequency(amount = this.amount * scalar,
                  unit = this.unit)

    override fun div(scalar: Number) =
        Frequency(amount = this.amount / scalar,
                  unit = this.unit)

    override fun to(unit: FrequencyUnit) =
        Frequency(amount = getAmountIn(unitAmount = this, newUnit = unit),
                  unit = unit)

    override fun invert() =
        Time(amount = amount.invert(),
             unit = unit.unitCounter.findUnit(TimeUnit::class)!!)

    // endregion
}
