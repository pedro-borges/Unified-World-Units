package pcb.uwu.amount.derived.optics

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.optics.IlluminanceUnit
import pcb.uwu.utils.UnitAmountUtils
import java.math.BigDecimal
import java.math.MathContext

open class Illuminance : CompositeUnitAmount<IlluminanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: IlluminanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    override operator fun plus(other: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount + other.into(this.unit).amount,
                    unit = this.unit)

    override operator fun minus(other: UnitAmount<IlluminanceUnit>) =
        Illuminance(amount = this.amount - other.into(this.unit).amount,
                    unit = this.unit)

    override fun times(other: BigDecimal, mathContext: MathContext) =
        Illuminance(amount = UnitAmountUtils.multipliedByScalar(this, other, mathContext),
                    unit = this.unit)

    override fun div(other: BigDecimal, mathContext: MathContext) =
        Illuminance(amount = UnitAmountUtils.dividedByScalar(this, other, mathContext),
                    unit = this.unit)

    override fun into(unit: IlluminanceUnit) =
        Illuminance(amount = UnitAmountUtils.getAmountIn(this, unit),
                    unit = unit)

    // endregion
}