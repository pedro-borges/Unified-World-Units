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

    const val CONVERT = 1000

    override val translationToCanonical =
        super.translationToCanonical.andThen { amount -> amount / CONVERT }

    override val translationFromCanonical =
        super.translationFromCanonical.andThen { amount -> amount * CONVERT }
}
