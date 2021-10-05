package pcb.uwu.unit.base

import java.math.BigDecimal

object FootUnit
    : LengthUnit(symbol = "ft",
                 singularName = "foot",
                 pluralName = "feet",
                 translationToCanonical = { it * BigDecimal("0.3048") },
                 translationFromCanonical = { it / BigDecimal("0.3048") })