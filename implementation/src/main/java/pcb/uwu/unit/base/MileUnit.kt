package pcb.uwu.unit.base

import pcb.uwu.unit.base.MileUnit.CONVERT

object MileUnit
    : LengthUnit(symbol = "mile",
                 singularName = "mile",
                 pluralName = "miles",
                 translationToCanonical = { it * CONVERT },
                 translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 1609.344
}
