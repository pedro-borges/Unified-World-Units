package pcb.uwu.unit.base

import pcb.uwu.unit.base.MinuteUnit.CONVERT

object MinuteUnit
    : TimeUnit(symbol = "min",
               singularName = "minute",
               pluralName = "minutes",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 60
}
