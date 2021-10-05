package pcb.uwu.unit.derived.mechanics

import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit

object MeterPerSecondUnit
    : SpeedUnit(lengthUnit = MeterUnit,
                timeUnit = SecondUnit)
