package pcb.uwu.unit.base

import java.math.BigDecimal

object YardUnit
    : LengthUnit(symbol = "yd",
                 singularName = "yard",
                 pluralName = "yards",
                 translationToCanonical = { it * BigDecimal("0.9144") },
                 translationFromCanonical = { it / BigDecimal("0.9144") })
