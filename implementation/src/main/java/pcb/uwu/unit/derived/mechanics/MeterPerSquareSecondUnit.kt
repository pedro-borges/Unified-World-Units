package pcb.uwu.unit.derived.mechanics

import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object MeterPerSquareSecondUnit
    : AccelerationUnit(lengthUnit = MeterUnit,
                       timeUnit1 = SecondUnit,
                       timeUnit2 = SecondUnit)
