package pcb.uwu.unit.base

import pcb.uwu.unit.base.OunceUnit.CONVERT

object OunceUnit
    : MassUnit(symbol = "oz",
               singularName = "ounce",
               pluralName = "ounces",
               translationToCanonical = { it * CONVERT },
               translationFromCanonical = { it / CONVERT })
{
    const val CONVERT = 28.349523125
}
