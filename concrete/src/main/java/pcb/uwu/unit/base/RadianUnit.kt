package pcb.uwu.unit.base

import java.util.function.Function.identity

object RadianUnit
    : AngleUnit(symbol = "rad",
                singularName = "Radian",
                pluralName = "Radians",
                translationToCanonical = identity(),
                translationFromCanonical = identity())
