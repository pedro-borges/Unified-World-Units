package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit

open class ElectricConductanceUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(timeUnit, 3)
                        .major(electricCurrentUnit, 2)
                        .minor(massUnit)
                        .minor(lengthUnit, 2))

    constructor(electricResistanceUnit: ElectricResistanceUnit)
            : super(UnitCounter()
                        .minor(electricResistanceUnit.unitCounter))
}