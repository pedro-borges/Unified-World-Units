package pcb.uwu.amount.derived.geometry.area

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.geometry.AreaFactory
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.util.UnitAmountUtils.getAmountIn

class SquareMetersFactory : AreaFactory()
{
    override fun circle(radius: Length) =
        SquareMeters(CIRCLE_FUNCTION(getAmountIn(unitAmount = radius, newUnit = MeterUnit)))

    override fun square(side: Length) =
        SquareMeters(SQUARE_FUNCTION(getAmountIn(unitAmount = side, newUnit = MeterUnit)))
}
