package pcb.uwu.unit.derived.fundamental

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit

open class VolumeUnit : CompositeUnit
{
    constructor(lengthUnit: LengthUnit,
                heightUnit: LengthUnit,
                depthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(lengthUnit)
                        .major(heightUnit)
                        .major(depthUnit))

    constructor(areaUnit: AreaUnit,
                sizeUnit: LengthUnit)
            : super(UnitCounter()
                        .major(areaUnit)
                        .major(sizeUnit))

    constructor(energyUnit: EnergyUnit,
                pressureUnit: PressureUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .major(pressureUnit))
}