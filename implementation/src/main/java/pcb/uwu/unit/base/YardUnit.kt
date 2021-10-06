package pcb.uwu.unit.base

import pcb.uwu.unit.base.YardUnit.CONVERT

object YardUnit
    : LengthUnit(symbol = "yd",
                 singularName = "yard",
                 pluralName = "yards",
                 translationToCanonical = { it * CONVERT },
                 translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 0.9144
}
