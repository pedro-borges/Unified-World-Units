package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.fundamental.VolumeUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit

open class EnergyUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                massUnit: MassUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit, 2)
                        .minor(timeUnit, 2))

    constructor(forceUnit: ForceUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit.unitCounter)
                        .major(lengthUnit))

    constructor(pressureUnit: PressureUnit,
                volumeUnit: VolumeUnit)
            : super(UnitCounter()
                        .major(pressureUnit.unitCounter)
                        .major(volumeUnit.unitCounter))

    constructor(powerUnit: PowerUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(powerUnit.unitCounter)
                        .major(timeUnit))

    constructor(electricChargeUnit: ElectricChargeUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(electricChargeUnit.unitCounter)
                        .major(electricPotentialUnit.unitCounter))
}