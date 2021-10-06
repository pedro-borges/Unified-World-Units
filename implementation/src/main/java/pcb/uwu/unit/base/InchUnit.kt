package pcb.uwu.unit.base

import java.math.BigDecimal

object InchUnit
    : LengthUnit(symbol = "in",
                 singularName = "inch",
                 pluralName = "inches",
                 translationToCanonical = { it * BigDecimal("0.0254") },
                 translationFromCanonical = { it / BigDecimal("0.0254") })
