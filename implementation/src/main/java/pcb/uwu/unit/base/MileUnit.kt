package pcb.uwu.unit.base

val SCALE = 1609.344

object MileUnit
    : LengthUnit(symbol = "mile",
                 singularName = "mile",
                 pluralName = "miles",
                 translationToCanonical = { it * SCALE },
                 translationFromCanonical = { it / SCALE })
