package pcb.uwu.amount.derived.fundamental.area

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.derived.fundamental.AreaFactory
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.utils.UnitAmountUtils.getAmountIn

class SquareMetersFactory : AreaFactory()
{
    override fun circle(radius: Length) =
        SquareMeters(CIRCLE_FUNCTION(getAmountIn(unitAmount = radius, newUnit = METER)))

    override fun square(side: Length) =
        SquareMeters(SQUARE_FUNCTION(getAmountIn(unitAmount = side, newUnit = METER)))
}