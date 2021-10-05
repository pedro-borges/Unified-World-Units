package pcb.uwu.unit.base

import java.util.function.Function.identity

object CandelaUnit
    : LuminousIntensityUnit(symbol = "cd",
                            singularName = "candela",
                            pluralName = "candelas",
                            translationToCanonical = identity(),
                            translationFromCanonical = identity())
