package pcb.uwu.unit.derived.electromagnetism

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit
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
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(electricPotentialUnit: ElectricPotentialUnit,
                timeUnit: TimeUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(electricPotentialUnit)
                        .major(timeUnit)
                        .minor(lengthUnit)
                        .minor(lengthUnit))

    constructor(forceUnit: ForceUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .minor(electricCurrentUnit)
                        .minor(lengthUnit))

    constructor(energyUnit: EnergyUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(electricCurrentUnit)
                        .minor(lengthUnit)
                        .minor(lengthUnit))

    constructor(electricInductanceUnit: ElectricInductanceUnit,
                electricCurrentUnit: ElectricCurrentUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(electricInductanceUnit)
                        .major(electricCurrentUnit)
                        .minor(lengthUnit)
                        .minor(lengthUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit)
                        .minor(areaUnit))

    constructor(massUnit: MassUnit,
                electricChargeUnit: ElectricChargeUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .minor(electricChargeUnit)
                        .minor(timeUnit))

    constructor(forceUnit: ForceUnit,
                timeUnit: TimeUnit,
                electricChargeUnit: ElectricChargeUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .major(timeUnit)
                        .minor(electricChargeUnit)
                        .minor(lengthUnit))
}