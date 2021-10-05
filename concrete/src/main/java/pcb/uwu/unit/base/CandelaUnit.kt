package pcb.uwu.unit.base

import pcb.uwu.utils.identity

object CandelaUnit
    : LuminousIntensityUnit(symbol = "cd",
                            singularName = "candela",
                            pluralName = "candelas",
                            translationToCanonical = identity(),
                            translationFromCanonical = identity())
