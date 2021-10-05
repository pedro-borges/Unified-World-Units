package pcb.uwu.unit.base

import pcb.uwu.utils.identity

object SecondUnit
    : TimeUnit(symbol = "s",
               singularName = "second",
               pluralName = "seconds",
               translationToCanonical = identity(),
               translationFromCanonical = identity())
