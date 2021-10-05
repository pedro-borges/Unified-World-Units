package pcb.uwu.unit.derived.termodynamics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.unit.derived.geometry.VolumeUnit
import pcb.uwu.unit.derived.mechanics.ForceUnit

open class EnergyUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                massUnit: MassUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit)
                        .major(lengthUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(forceUnit: ForceUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(forceUnit)
                        .major(lengthUnit))

    constructor(pressureUnit: PressureUnit,
                volumeUnit: VolumeUnit)
            : super(UnitCounter()
                        .major(pressureUnit)
                        .major(volumeUnit))

    constructor(powerUnit: PowerUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(powerUnit)
                        .major(timeUnit))

    constructor(electricChargeUnit: ElectricChargeUnit,
                electricPotentialUnit: ElectricPotentialUnit)
            : super(UnitCounter()
                        .major(electricChargeUnit)
                        .major(electricPotentialUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                electricCurrentUnit: ElectricCurrentUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit)
                        .major(electricCurrentUnit))
}