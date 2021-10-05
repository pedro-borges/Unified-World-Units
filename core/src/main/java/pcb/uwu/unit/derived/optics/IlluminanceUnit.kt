package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.fundamental.AreaUnit
import pcb.uwu.unit.scalar.SolidAngleUnit

open class IlluminanceUnit : CompositeUnit
{
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                solidAngleUnit: SolidAngleUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit.unitCounter)
                        .major(solidAngleUnit)
                        .minor(lengthUnit, 2))

    constructor(luminousFluxUnit: LuminousFluxUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(luminousFluxUnit.unitCounter)
                        .minor(areaUnit.unitCounter))
}