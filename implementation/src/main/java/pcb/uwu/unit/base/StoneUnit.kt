package pcb.uwu.unit.base

import pcb.uwu.unit.base.StoneUnit.CONVERT

object StoneUnit
    : MassUnit(symbol = "st",
               singularName = "stone",
               pluralName = "stones",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 6.35029318
}
