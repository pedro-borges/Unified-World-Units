package pcb.uwu.amount.derived.fundamental

import pcb.uwu.amount.base.Length
import pcb.uwu.core.Amount
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.utils.MathUtils.PI

open class VolumeFactory
{
    open fun sphere(radius: Length) =
        Volume(amount = SPHERE_FUNCTION(radius.amount),
               unit = VolumeUnit(radius.unit, radius.unit, radius.unit))

    open fun cube(side: Length) =
        Volume(amount = CUBE_FUNCTION(side.amount),
               unit = VolumeUnit(side.unit, side.unit, side.unit))

    companion object
    {
        @JvmField
        val SPHERE_FUNCTION =
            { radius: Amount ->
                radius.pow(3) * 4 / 3 * PI
            }

        @JvmField
        val CUBE_FUNCTION =
            { side: Amount ->
                side.pow(3)
            }
    }
}