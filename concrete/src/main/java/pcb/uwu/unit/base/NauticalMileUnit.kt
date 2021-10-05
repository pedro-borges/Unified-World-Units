package pcb.uwu.unit.base

import java.math.BigDecimal

object NauticalMileUnit
    : LengthUnit(symbol = "mile",
                 singularName = "mile",
                 pluralName = "miles",
                 translationToCanonical = { it * BigDecimal("1852") },
                 translationFromCanonical = { it / BigDecimal("1852") })
