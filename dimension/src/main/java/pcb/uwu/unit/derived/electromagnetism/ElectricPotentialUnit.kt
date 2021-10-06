package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PowerUnit

open class ElectricPotentialUnit : CompositeUnit
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
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(energyUnit: EnergyUnit,
                electricChargeUnit: ElectricChargeUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(electricChargeUnit))

    constructor(powerUnit: PowerUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(powerUnit)
                        .minor(electricCurrentUnit))

    constructor(electricChargeUnit: ElectricChargeUnit,
                electricCapacitanceUnit: ElectricCapacitanceUnit)
            : super(UnitCounter()
                        .major(electricChargeUnit)
                        .minor(electricCapacitanceUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit)
                        .minor(timeUnit))

    constructor(electricResistanceUnit: ElectricResistanceUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(electricResistanceUnit)
                        .major(electricCurrentUnit))

    constructor(electricCurrentUnit: ElectricCurrentUnit,
                electricConductanceUnit: ElectricConductanceUnit)
            : super(UnitCounter()
                        .major(electricCurrentUnit)
                        .major(electricConductanceUnit))
}
