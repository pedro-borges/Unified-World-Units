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

    override operator fun times(other: Number) =
        Pace(amount = this.amount * other,
             unit = this.unit)

    override operator fun div(other: Number) =
        Pace(amount = this.amount / other,
             unit = this.unit)

    override fun into(unit: PaceUnit) =
        Pace(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
             unit = unit)

    override fun invert() =
        Speed(amount = amount.invert(),
              unit = SpeedUnit(unit))

    // endregion

    // region composition

    fun times(length: Length) =
        Time(amount = (this * length).amount,
             unit = unit.unitCounter.findUnit(TimeUnit::class.java)!!)

    // endregion
}