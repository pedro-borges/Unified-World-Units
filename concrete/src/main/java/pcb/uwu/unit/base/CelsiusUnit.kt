package pcb.uwu.unit.base

import java.math.BigDecimal

object CelsiusUnit
    : TemperatureUnit(symbol = "°C",
                      singularName = "celsius",
                      pluralName = "celsius",
                      translationToCanonical = { it - BigDecimal("273.15") },
                      translationFromCanonical = { it + BigDecimal("273.15") })
