package pcb.uwu.unit.base

import java.math.BigDecimal

object PoundUnit
    : MassUnit(symbol = "lb",
               singularName = "pound",
               pluralName = "pounds",
               translationToCanonical = { it * BigDecimal("0.45359237") },
               translationFromCanonical = { it / BigDecimal("0.45359237") })
