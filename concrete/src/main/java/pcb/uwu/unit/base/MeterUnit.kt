package pcb.uwu.unit.base

import pcb.uwu.utils.identity

object MeterUnit
    : LengthUnit(symbol = "m",
                 singularName = "meter",
                 pluralName = "meters",
                 translationToCanonical = identity(),
                 translationFromCanonical = identity())
