package pcb.uwu.unit.base

import pcb.uwu.unit.base.HourUnit.CONVERT

object HourUnit
    : TimeUnit(symbol = "h",
               singularName = "hour",
               pluralName = "hours",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 3600
}
