package pcb.uwu.unit.base

import pcb.uwu.unit.base.NauticalMileUnit.CONVERT

object NauticalMileUnit
    : LengthUnit(symbol = "mile",
                 singularName = "mile",
                 pluralName = "miles",
                 translationToCanonical = { it * CONVERT },
                 translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 1852
}
