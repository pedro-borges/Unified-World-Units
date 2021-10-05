package pcb.uwu.unit.base

import java.math.BigDecimal

object WeekUnit
    : TimeUnit(symbol = "wk",
               singularName = "week",
               pluralName = "weeks",
               translationToCanonical = { it * BigDecimal(604800) },
               translationFromCanonical = { it / BigDecimal(604800) })
