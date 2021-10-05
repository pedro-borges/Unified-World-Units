package pcb.uwu.unit.derived.fundamental

import pcb.uwu.core.CompositeUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.LuminousIntensityUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit
import pcb.uwu.unit.derived.optics.LuminanceUnit

open class AreaUnit : CompositeUnit
{
    constructor(length: LengthUnit, height: LengthUnit)
            : super(UnitCounter()
                        .major(length)
                        .major(height))

    constructor(luminousIntensityUnit: LuminousIntensityUnit,
                luminanceUnit: LuminanceUnit)
            : super(UnitCounter()
                        .major(luminousIntensityUnit)
                        .minor(luminanceUnit))

    constructor(magneticFluxUnit: MagneticFluxUnit,
                magneticFieldUnit: MagneticFieldUnit)
            : super(UnitCounter()
                        .major(magneticFluxUnit)
                        .minor(magneticFieldUnit))
}