package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit

open class PowerUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                massUnit: MassUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(timeUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(forceUnit: ForceUnit,
                lengthUnit: LengthUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .major(lengthUnit)
                        .minor(timeUnit))

    constructor(energyUnit: EnergyUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(timeUnit))

    constructor(electricCurrentUnit: ElectricCurrentUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(electricPotentialUnit))
}
