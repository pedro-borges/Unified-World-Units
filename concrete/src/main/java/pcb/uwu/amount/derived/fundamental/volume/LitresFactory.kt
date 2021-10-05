package pcb.uwu.amount.derived.fundamental.volume

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.fundamental.VolumeFactory
import pcb.uwu.core.Magnitude.DECI
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

class LitresFactory : VolumeFactory()
{
    override fun sphere(radius: Length) =
        Litres(SPHERE_FUNCTION(getAmountIn(unitAmount = radius,
                                           magnitude = DECI,
                                           newUnit = MeterUnit)))

    override fun cube(side: Length) =
        Litres(CUBE_FUNCTION(getAmountIn(unitAmount = side,
                                         magnitude = DECI,
                                         newUnit = MeterUnit)))
}