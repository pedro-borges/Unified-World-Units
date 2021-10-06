package pcb.uwu.unit.base

import pcb.uwu.unit.base.PercentageUnit.CONVERT

object PercentageUnit : ScalarUnit(symbol = "%",
                                   singularName = "percent",
                                   pluralName = "percent",
                                   translationToCanonical = { it / CONVERT },
                                   translationFromCanonical = { it * CONVERT })
{
    const val CONVERT = 100
}

