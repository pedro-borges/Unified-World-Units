package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit

class PaceUnit : CompositeUnit
{
    constructor(timeUnit: TimeUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(timeUnit)
                        .minor(lengthUnit))

    constructor(speedUnit: SpeedUnit)
            : super(UnitCounter()
                        .minor(speedUnit.unitCounter))
}