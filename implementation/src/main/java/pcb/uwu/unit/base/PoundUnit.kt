package pcb.uwu.unit.base

import pcb.uwu.unit.base.PoundUnit.CONVERT

object PoundUnit
    : MassUnit(symbol = "lb",
               singularName = "pound",
               pluralName = "pounds",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 0.45359237
}
