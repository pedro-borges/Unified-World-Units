package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit

class AccelerationUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(lengthUnit: SpeedUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .minor(timeUnit))
}