package pcb.uwu.amount.base

import pcb.uwu.core.CompositeUnitAmount
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmountOfSubstanceUnit
import pcb.uwu.utils.UnitAmountUtils

open class AmountOfSubstance : CompositeUnitAmount<AmountOfSubstanceUnit>
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(amount, magnitude, unit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL,
                unit: AmountOfSubstanceUnit)
            : super(amount, magnitude, unit)

    // region UnitAmount

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun plus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(amount = this.amount + (amountOfSubstance to this.unit).amount,
                          unit = this.unit)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun minus(amountOfSubstance: UnitAmount<AmountOfSubstanceUnit>) =
        AmountOfSubstance(amount = this.amount - (amountOfSubstance to this.unit).amount,
                          unit = this.unit)

    override fun times(number: Number) =
        AmountOfSubstance(amount = this.amount * number,
                          unit = this.unit)

    override fun div(number: Number) =
        AmountOfSubstance(amount = this.amount / number,
                          unit = this.unit)

    override fun to(unit: AmountOfSubstanceUnit) =
        AmountOfSubstance(amount = UnitAmountUtils.getAmountIn(unitAmount = this, newUnit = unit),
                          unit = unit)

    // endregion
}