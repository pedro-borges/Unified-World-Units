package pcb.uwu.util

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.Unit
import pcb.uwu.core.UnitAmount

object UnitAmountUtils
{
    @JvmStatic
    @JvmOverloads
    fun <U : Unit> getAmountIn(unitAmount: UnitAmount<U>, magnitude: Magnitude = NATURAL, newUnit: U) =
        if (unitAmount.unit == newUnit) unitAmount.amount.div(magnitude.amount)
        else unitAmount.unit.translationToCanonical.andThen(newUnit.translationFromCanonical)(unitAmount.amount)
            .div(magnitude.amount)

    @JvmStatic
    fun <U : Unit> plusAmount(unitAmount: UnitAmount<U>, other: UnitAmount<U>) =
        unitAmount.amount.plus(getAmountIn(unitAmount = other,
                                           newUnit = unitAmount.unit))

    @JvmStatic
    fun <U : Unit> minusAmount(unitAmount: UnitAmount<U>, other: UnitAmount<U>) =
        unitAmount.amount.minus(getAmountIn(unitAmount = other,
                                            newUnit = unitAmount.unit))

    @JvmStatic
    fun <U : Unit> times(unitAmount: UnitAmount<U>,
                         other: Number) =
        unitAmount.amount.times(other)

    @JvmStatic
    fun <U : Unit> dividedByScalar(unitAmount: UnitAmount<U>,
                                   other: Number) =
        unitAmount.amount.div(other)
}
