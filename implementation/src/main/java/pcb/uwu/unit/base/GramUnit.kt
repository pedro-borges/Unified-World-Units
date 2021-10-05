package pcb.uwu.unit.base

import java.math.BigDecimal

object GramUnit
    : MassUnit(symbol = "g",
               singularName = "gram",
               pluralName = "grams",
               translationToCanonical = { it * BigDecimal(1000) },
               translationFromCanonical = { it / BigDecimal(1000) })
