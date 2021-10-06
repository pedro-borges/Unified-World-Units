package pcb.uwu.unit.derived.optics

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.geometry.AreaUnit
import pcb.uwu.unit.derived.geometry.SolidAngleUnit

open class IlluminanceUnit : CompositeUnit
{
    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                solidAngleUnit: SolidAngleUnit,
                lengthUnit: LengthUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit)
                        .major(solidAngleUnit)
                        .minor(lengthUnit)
                        .minor(lengthUnit))

    constructor(luminousFluxUnit: LuminousFluxUnit,
                areaUnit: AreaUnit)
            : super(UnitCounter()
                        .major(luminousFluxUnit)
                        .minor(areaUnit))
}
