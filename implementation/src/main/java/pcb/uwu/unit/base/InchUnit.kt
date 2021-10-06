package pcb.uwu.unit.base

import pcb.uwu.unit.base.InchUnit.CONVERT

object InchUnit
    : LengthUnit(symbol = "in",
                 singularName = "inch",
                 pluralName = "inches",
                 translationToCanonical = { it * CONVERT },
                 translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 0.0254
}

