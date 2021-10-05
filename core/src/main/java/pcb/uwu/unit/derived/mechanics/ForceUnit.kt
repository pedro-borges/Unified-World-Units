package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit

open class ForceUnit : CompositeUnit
{
    constructor(mass: MassUnit,
                length: LengthUnit,
                time: TimeUnit)
            : super(UnitCounter()
                        .major(mass)
                        .major(length)
                        .minor(time, 2))

    constructor(massUnit: MassUnit,
                accelerationUnit: AccelerationUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(accelerationUnit.unitCounter))
}