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
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(electricCurrentUnit)
                        .minor(electricCurrentUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(massUnit: MassUnit, lengthUnit: LengthUnit, electricChargeUnit: ElectricChargeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(electricChargeUnit))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(electricCurrentUnit)
                        .minor(electricCurrentUnit))

    constructor(magneticFieldUnit: MagneticFieldUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(magneticFieldUnit)
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(electricCurrentUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit)
                        .minor(electricCurrentUnit))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit)
                        .major(timeUnit)
                        .minor(electricCurrentUnit))

    constructor(timeUnit: TimeUnit, electricCapacitanceUnit: ElectricCapacitanceUnit)
            : super(UnitCounter()
                        .major(timeUnit)
                        .major(timeUnit)
                        .minor(electricCapacitanceUnit))

    constructor(electricResistanceUnit: ElectricResistanceUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricResistanceUnit)
                        .major(timeUnit))
}