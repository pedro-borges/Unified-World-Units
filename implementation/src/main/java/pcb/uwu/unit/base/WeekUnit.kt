package pcb.uwu.unit.base

import pcb.uwu.unit.base.WeekUnit.CONVERT

object WeekUnit
    : TimeUnit(symbol = "wk",
               singularName = "week",
               pluralName = "weeks",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 604800
}

