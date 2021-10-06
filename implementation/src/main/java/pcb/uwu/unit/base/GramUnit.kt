package pcb.uwu.unit.base

import pcb.uwu.unit.base.GramUnit.CONVERT

object GramUnit
    : MassUnit(symbol = "g",
               singularName = "gram",
               pluralName = "grams",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 1000
}
