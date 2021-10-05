package pcb.uwu.unit.base

import java.math.BigDecimal

object HourUnit
    : TimeUnit(symbol = "h",
               singularName = "hour",
               pluralName = "hours",
               translationToCanonical = { it * BigDecimal(3600) },
               translationFromCanonical = { it / BigDecimal(3600) })
