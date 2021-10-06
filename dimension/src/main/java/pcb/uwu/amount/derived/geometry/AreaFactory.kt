package pcb.uwu.amount.derived.geometry

import pcb.uwu.amount.base.Length
import pcb.uwu.core.Amount
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.util.MathUtils.PI

open class AreaFactory
{
    open fun circle(radius: Length) =
        Area(amount = CIRCLE_FUNCTION(radius.amount),
             unit = AreaUnit(radius.unit, radius.unit))

    open fun square(side: Length) =
        Area(amount = SQUARE_FUNCTION(side.amount),
             unit = AreaUnit(side.unit, side.unit))

    companion object
    {
        @JvmField
        val CIRCLE_FUNCTION =
            { radius: Amount ->
                radius.pow(2) * PI
            }

        @JvmField
        val SQUARE_FUNCTION =
            { amount: Amount ->
                amount.pow(2)
            }
    }
}
