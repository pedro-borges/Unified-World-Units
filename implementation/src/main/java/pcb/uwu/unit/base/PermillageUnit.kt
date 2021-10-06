package pcb.uwu.unit.base

import pcb.uwu.unit.base.PermillageUnit.CONVERT

object PermillageUnit : ScalarUnit(symbol = "‰",
                                   singularName = "permillage",
                                   pluralName = "permillage",
                                   translationToCanonical = { it / CONVERT },
                                   translationFromCanonical = { it * CONVERT })
{
    const val CONVERT = 1000
}
