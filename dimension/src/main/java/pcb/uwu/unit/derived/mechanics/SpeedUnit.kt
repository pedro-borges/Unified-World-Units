package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit

open class SpeedUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .minor(timeUnit))

    constructor(paceUnit: PaceUnit)
            : super(UnitCounter()
                        .minor(paceUnit))
}
