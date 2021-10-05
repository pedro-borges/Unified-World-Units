package pcb.uwu.unit.base

import java.math.BigDecimal

object MinuteUnit
    : TimeUnit(symbol = "min",
               singularName = "minute",
               pluralName = "minutes",
               translationToCanonical = { it * BigDecimal(60) },
               translationFromCanonical = { it / BigDecimal(60) })
