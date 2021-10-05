package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit

open class ElectricChargeUnit
    : CompositeUnit
{
    constructor(electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(timeUnit))

    constructor(energyUnit: EnergyUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .major(electricPotentialUnit))
}