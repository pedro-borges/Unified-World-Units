package pcb.uwu.unit.base

import java.math.BigDecimal

object FahrenheitUnit
    : TemperatureUnit(symbol = "°F",
                      singularName = "fahrenheit",
                      pluralName = "fahrenheit",
                      translationToCanonical = { (it + BigDecimal("459.67")) * 5 / 9 },
                      translationFromCanonical = { it * 9 / 5 - BigDecimal("459.67") })
