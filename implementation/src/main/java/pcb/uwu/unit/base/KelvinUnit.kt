package pcb.uwu.unit.base

import pcb.uwu.util.identity

object KelvinUnit
    : TemperatureUnit(symbol = "K",
                      singularName = "kelvin",
                      pluralName = "kelvins",
                      translationToCanonical = identity(),
                      translationFromCanonical = identity())
