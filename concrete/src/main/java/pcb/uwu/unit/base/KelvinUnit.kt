package pcb.uwu.unit.base

import java.util.function.Function.identity

object KelvinUnit
    : TemperatureUnit(symbol = "K",
                      singularName = "kelvin",
                      pluralName = "kelvins",
                      translationToCanonical = identity(),
                      translationFromCanonical = identity())
