package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit

open class ElectricResistanceUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(timeUnit)
                        .minor(timeUnit)
                        .minor(timeUnit)
                        .minor(electricCurrentUnit)
                        .minor(electricCurrentUnit))

    constructor(electricConductanceUnit: ElectricConductanceUnit)
            : super(UnitCounter()
                        .minor(electricConductanceUnit))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit)
                        .major(electricCurrentUnit))
}