package pcb.uwu.unit.base

import java.math.BigDecimal

object MileUnit
    : LengthUnit(symbol = "mile",
                 singularName = "mile",
                 pluralName = "miles",
                 translationToCanonical = { it * BigDecimal("1609.344") },
                 translationFromCanonical = { it / BigDecimal("1609.344") })
