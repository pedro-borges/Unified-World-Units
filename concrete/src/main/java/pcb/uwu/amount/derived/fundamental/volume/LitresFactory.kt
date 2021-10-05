package pcb.uwu.amount.derived.fundamental.volume

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.fundamental.VolumeFactory
import pcb.uwu.core.Magnitude.DECI
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

class LitresFactory : VolumeFactory()
{
    override fun sphere(radius: Length) =
        Litres(SPHERE_FUNCTION.invoke(getAmountIn(unitAmount = radius,
                                                  magnitude = DECI,
                                                  newUnit = METER)))

    override fun cube(side: Length) =
        Litres(CUBE_FUNCTION.invoke(getAmountIn(unitAmount = side,
                                                magnitude = DECI,
                                                newUnit = METER)))
}