package pcb.uwu.unit.base

import java.math.BigDecimal

object DayUnit
    : TimeUnit(symbol = "d",
               singularName = "day",
               pluralName = "days",
               translationToCanonical = { it * BigDecimal(86400) },
               translationFromCanonical = { it / BigDecimal(86400) })
