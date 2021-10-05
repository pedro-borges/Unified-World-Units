package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit

open class ElectricInductanceUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit, 2)
                        .minor(electricCurrentUnit, 2)
                        .minor(timeUnit, 2))

    constructor(massUnit: MassUnit, lengthUnit: LengthUnit, electricChargeUnit: ElectricChargeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit, 2)
                        .minor(electricChargeUnit.unitCounter))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(energyUnit.unitCounter)
                        .minor(electricCurrentUnit, 2))

    constructor(magneticFieldUnit: MagneticFieldUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(magneticFieldUnit.unitCounter)
                        .major(lengthUnit, 2)
                        .minor(electricCurrentUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit.unitCounter)
                        .minor(electricCurrentUnit))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit.unitCounter)
                        .major(timeUnit)
                        .minor(electricCurrentUnit))

    constructor(timeUnit: TimeUnit, electricCapacitanceUnit: ElectricCapacitanceUnit)
            : super(UnitCounter()
                        .major(timeUnit, 2)
                        .minor(electricCapacitanceUnit.unitCounter))

    constructor(electricResistanceUnit: ElectricResistanceUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricResistanceUnit.unitCounter)
                        .major(timeUnit))
}