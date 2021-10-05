package pcb.uwu.unit.base

import java.math.BigDecimal

object StoneUnit
    : MassUnit(symbol = "st",
               singularName = "stone",
               pluralName = "stones",
               translationToCanonical = { it * BigDecimal("6.35029318") },
               translationFromCanonical = { it / BigDecimal("6.35029318") })
