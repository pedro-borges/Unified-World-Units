package pcb.uwu.unit.base

import pcb.uwu.unit.base.DayUnit.CONVERT
import java.math.BigDecimal


object DayUnit
    : TimeUnit(symbol = "d",
               singularName = "day",
               pluralName = "days",
               translationToCanonical = { it * BigDecimal(CONVERT) },
               translationFromCanonical = { it / BigDecimal(CONVERT) })
{
    const val CONVERT = 86400
}
