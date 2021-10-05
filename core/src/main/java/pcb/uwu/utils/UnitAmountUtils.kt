package pcb.uwu.utils

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.Unit
import pcb.uwu.core.UnitAmount

object UnitAmountUtils
{
    @JvmStatic
    @JvmOverloads
    fun <U : Unit> getAmountIn(unitAmount: UnitAmount<U>, magnitude: Magnitude = NATURAL, newUnit: U) =
        if (unitAmount.unit == newUnit) unitAmount.amount.div(magnitude.value)
        else unitAmount.amount
            .transformed(unitAmount.unit.translationToCanonical.andThen(newUnit.translationFromCanonical))
            .div(magnitude.value)

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