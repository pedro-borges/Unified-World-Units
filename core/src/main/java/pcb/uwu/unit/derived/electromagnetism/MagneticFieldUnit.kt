package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit

open class MagneticFieldUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .minor(electricCurrentUnit)
                        .minor(timeUnit, 2))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit.unitCounter)
                        .major(timeUnit)
                        .minor(lengthUnit, 2))

    constructor(forceUnit: ForceUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit.unitCounter)
                        .minor(electricCurrentUnit)
                        .minor(lengthUnit))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(energyUnit.unitCounter)
                        .minor(electricCurrentUnit)
                        .minor(lengthUnit, 2))

    constructor(electricInductanceUnit: ElectricInductanceUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(electricInductanceUnit.unitCounter)
                        .major(electricCurrentUnit)
                        .minor(lengthUnit, 2))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit.unitCounter)
                        .minor(lengthUnit, 2))

    constructor(massUnit: MassUnit,
                electricChargeUnit: ElectricChargeUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .minor(electricChargeUnit.unitCounter)
                        .minor(timeUnit))

    constructor(forceUnit: ForceUnit,
                timeUnit: TimeUnit,
                electricChargeUnit: ElectricChargeUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit.unitCounter)
                        .major(timeUnit)
                        .minor(electricChargeUnit.unitCounter)
                        .minor(lengthUnit))
}