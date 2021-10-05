package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Length
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.utils.MathUtils.PI
import java.math.MathContext
import java.util.function.BiFunction

open class AreaFactory
{
    open fun circle(radius: Length, mathContext: MathContext) =
        Area(amount = CIRCLE_FUNCTION.apply(radius.amount, mathContext),
             unit = AreaUnit(radius.unit, radius.unit))

    open fun square(side: Length, mathContext: MathContext) =
        Area(amount = SQUARE_FUNCTION.apply(side.amount, mathContext),
             unit = AreaUnit(side.unit, side.unit))

    companion object
    {
        @JvmField
        val CIRCLE_FUNCTION =
            BiFunction { radius: BigDecimalAmount, mathContext: MathContext ->
                radius.pow(2, mathContext).times(PI, mathContext)
            }

        @JvmField
        val SQUARE_FUNCTION =
            BiFunction { amount: BigDecimalAmount, mathContext: MathContext ->
                amount.pow(2, mathContext)
            }
    }
}