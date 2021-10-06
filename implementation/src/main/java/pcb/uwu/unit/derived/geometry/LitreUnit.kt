package pcb.uwu.unit.derived.geometry

import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.util.andThen


object LitreUnit
    : VolumeUnit(lengthUnit = MeterUnit,
                 heightUnit = MeterUnit,
                 depthUnit = MeterUnit)
{
    override val symbol = "l"
    override val singularName = "litre"
    override val pluralName = "litres"

    override val translationToCanonical =
        super.translationToCanonical.andThen { amount -> amount / 1000 }
    override val translationFromCanonical =
        super.translationFromCanonical.andThen { amount -> amount * 1000 }
}
