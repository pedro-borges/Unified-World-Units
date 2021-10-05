package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit

open class MagneticFluxUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                lengthUnit: LengthUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit, 2)
                        .minor(electricCurrentUnit)
                        .minor(timeUnit, 2))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit.unitCounter)
                        .major(timeUnit))

    constructor(electricInductanceUnit: ElectricInductanceUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricInductanceUnit.unitCounter)
                        .major(electricCurrentUnit.unitCounter))

    constructor(magneticFieldUnit: MagneticFieldUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(magneticFieldUnit.unitCounter)
                        .major(lengthUnit, 2))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(energyUnit.unitCounter)
                        .minor(electricCurrentUnit.unitCounter))
}