package pcb.uwu.unit.derived.geometry

import pcb.uwu.unit.base.MeterUnit

object CubicMeterUnit
    : VolumeUnit(lengthUnit = MeterUnit,
                 heightUnit = MeterUnit,
                 depthUnit = MeterUnit)
