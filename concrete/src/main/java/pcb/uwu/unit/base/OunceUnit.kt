package pcb.uwu.unit.base

import java.math.BigDecimal

object OunceUnit
    : MassUnit(symbol = "oz",
               singularName = "ounce",
               pluralName = "ounces",
               translationToCanonical = { it * BigDecimal("28.349523125") },
               translationFromCanonical = { it / BigDecimal("28.349523125") })
