package pcb.uwu.unit.base

object MinuteUnit
    : TimeUnit(symbol = "min",
               singularName = "minute",
               pluralName = "minutes",
               translationToCanonical = { it * 60 },
               translationFromCanonical = { it / 60 })
