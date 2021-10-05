package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Length
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.utils.MathUtils.PI
import java.math.MathContext
import java.util.function.BiFunction

open class VolumeFactory
{
    open fun sphere(radius: Length, mathContext: MathContext) =
        Volume(amount = SPHERE_FUNCTION.apply(radius.amount, mathContext),
               unit = VolumeUnit(radius.unit, radius.unit, radius.unit))

    open fun cube(side: Length, mathContext: MathContext) =
        Volume(amount = CUBE_FUNCTION.apply(side.amount, mathContext),
               unit = VolumeUnit(side.unit, side.unit, side.unit))

    companion object
    {
        @JvmField
        val SPHERE_FUNCTION =
            BiFunction { radius: BigDecimalAmount, mathContext: MathContext ->
                radius.pow(3, mathContext).times(4).div(3, mathContext).times(PI, mathContext)
            }

        @JvmField
        val CUBE_FUNCTION =
            BiFunction { side: BigDecimalAmount, mathContext: MathContext ->
                side.pow(3, mathContext)
            }
    }
}