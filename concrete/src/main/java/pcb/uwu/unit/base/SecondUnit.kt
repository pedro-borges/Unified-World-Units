package pcb.uwu.unit.base

import java.util.function.Function.identity

object SecondUnit
    : TimeUnit(symbol = "s",
               singularName = "second",
               pluralName = "seconds",
               translationToCanonical = identity(),
               translationFromCanonical = identity())
