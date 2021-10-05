package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit

open class AccelerationUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                timeUnit1: TimeUnit,
                timeUnit2: TimeUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .minor(timeUnit1)
                        .minor(timeUnit2))

    constructor(lengthUnit: SpeedUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .minor(timeUnit))

    constructor(forceUnit: ForceUnit,
                massUnit: MassUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .minor(massUnit))
}