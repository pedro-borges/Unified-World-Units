package pcb.uwu.unit.base

import pcb.uwu.unit.base.FootUnit.CONVERT


object FootUnit
    : LengthUnit(symbol = "ft",
                 singularName = "foot",
                 pluralName = "feet",
                 translationToCanonical = { it * CONVERT },
                 translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 0.3048
}
