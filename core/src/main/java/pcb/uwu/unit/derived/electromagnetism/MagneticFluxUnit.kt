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
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(electricCurrentUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit)
                        .major(timeUnit))

    constructor(electricInductanceUnit: ElectricInductanceUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricInductanceUnit)
                        .major(electricCurrentUnit))

    constructor(magneticFieldUnit: MagneticFieldUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(magneticFieldUnit)
                        .major(lengthUnit)
                        .major(lengthUnit))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(electricCurrentUnit))
}