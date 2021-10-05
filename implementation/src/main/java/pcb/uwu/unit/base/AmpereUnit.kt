package pcb.uwu.unit.base

import pcb.uwu.util.identity

object AmpereUnit
    : ElectricCurrentUnit(symbol = "A",
                          singularName = "ampere",
                          pluralName = "amperes",
                          translationToCanonical = identity(),
                          translationFromCanonical = identity())