package pcb.uwu.unit.base

import java.util.function.Function.identity

object MeterUnit
    : LengthUnit(symbol = "m",
                 singularName = "meter",
                 pluralName = "meters",
                 translationToCanonical = identity(),
                 translationFromCanonical = identity())
