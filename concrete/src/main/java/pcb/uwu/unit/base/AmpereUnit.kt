package pcb.uwu.unit.base

import java.util.function.Function.identity

object AmpereUnit
    : ElectricCurrentUnit(symbol = "A",
                          singularName = "ampere",
                          pluralName = "amperes",
                          translationToCanonical = identity(),
                          translationFromCanonical = identity())