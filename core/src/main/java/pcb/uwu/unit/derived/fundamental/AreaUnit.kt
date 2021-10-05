package pcb.uwu.unit.derived.fundamental

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit

open class AreaUnit : CompositeUnit
{
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(length: LengthUnit, height: LengthUnit)
            : super(UnitCounter()
                        .major(length)
                        .major(height))
}