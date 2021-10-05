package pcb.uwu.utils

import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.Unit
import pcb.uwu.core.UnitAmount
import java.math.BigDecimal
import java.math.MathContext
import java.math.MathContext.UNLIMITED

object UnitAmountUtils
{
    @JvmStatic
    @JvmOverloads
    fun <U : Unit> getAmountIn(unitAmount: UnitAmount<U>, magnitude: Magnitude = NATURAL, newUnit: U) =
        if (unitAmount.unit == newUnit) unitAmount.amount.div(magnitude.value, UNLIMITED)
        else unitAmount.amount
            .transformed(unitAmount.unit.translationToCanonical.andThen(newUnit.translationFromCanonical))
            .div(magnitude.value, UNLIMITED)

    @JvmStatic
    fun <U : Unit> plusAmount(unitAmount: UnitAmount<U>, other: UnitAmount<U>) =
        unitAmount.amount.plus(getAmountIn(unitAmount = other,
                                           newUnit = unitAmount.unit))

    @JvmStatic
    fun <U : Unit> minusAmount(unitAmount: UnitAmount<U>, other: UnitAmount<U>) =
        unitAmount.amount.minus(getAmountIn(unitAmount = other,
                                            newUnit = unitAmount.unit))

    @JvmStatic
    fun <U : Unit> multipliedByScalar(unitAmount: UnitAmount<U>,
                                      other: BigDecimal,
                                      mathContext: MathContext) =
        unitAmount.amount.times(other, mathContext)

    @JvmStatic
    fun <U : Unit> dividedByScalar(unitAmount: UnitAmount<U>,
                                   other: BigDecimal,
                                   mathContext: MathContext) =
        unitAmount.amount.div(other, mathContext)
}