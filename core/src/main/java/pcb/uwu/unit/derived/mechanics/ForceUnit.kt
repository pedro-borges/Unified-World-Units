package pcb.uwu.unit.derived.mechanics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.termodynamics.EnergyUnit
import pcb.uwu.unit.derived.termodynamics.PressureUnit

open class ForceUnit : CompositeUnit
{
    constructor(massUnit: MassUnit,
                lengthUnit: LengthUnit,
                timeUnit: TimeUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(lengthUnit)
                        .minor(timeUnit)
                        .minor(timeUnit))

    constructor(massUnit: MassUnit,
                accelerationUnit: AccelerationUnit)
            : super(UnitCounter()
                        .major(massUnit)
                        .major(accelerationUnit))

    constructor(energyUnit: EnergyUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(energyUnit)
                        .minor(lengthUnit))

    constructor(pressureUnit: PressureUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(pressureUnit)
                        .minor(areaUnit))
}