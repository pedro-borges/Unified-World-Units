package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit

open class ElectricCapacitanceUnit : CompositeUnit
{
    constructor(electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit,
                lengthUnit: LengthUnit,
                massUnit: MassUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(electricCurrentUnit)
                        .major(timeUnit)
                        .major(timeUnit)
                        .major(timeUnit)
                        .major(timeUnit)
                        .minor(lengthUnit)
                        .minor(lengthUnit)
                        .minor(massUnit))

    constructor(electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(timeUnit)
                        .minor(electricPotentialUnit))

    constructor(forceUnit: ForceUnit,
                lengthUnit: LengthUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .major(lengthUnit)
                        .minor(electricPotentialUnit))

    constructor(electricChargeUnit: ElectricChargeUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(electricChargeUnit)
                        .minor(electricPotentialUnit))

    constructor(timeUnit: TimeUnit,
                electricResistanceUnit: ElectricResistanceUnit)
            : super(UnitCounter()
                        .major(timeUnit)
                        .minor(electricResistanceUnit))
}
