package pcb.uwu.unit.derived.fundamental

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit

open class VolumeUnit : CompositeUnit
{
    constructor(length: LengthUnit,
                height: LengthUnit,
                depth: LengthUnit)
            : super(UnitCounter()
                        .major(length)
                        .major(height)
                        .major(depth))

    constructor(areaUnit: AreaUnit,
                length: LengthUnit)
            : super(areaUnit.unitCounter.major(length))
}