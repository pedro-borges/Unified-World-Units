package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit

open class PressureUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                massUnit: MassUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .minor(lengthUnit)
                        .minor(timeUnit, 2))
    {
    }

    constructor(forceUnit: ForceUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(forceUnit.unitCounter)
                        .minor(areaUnit.unitCounter))
}