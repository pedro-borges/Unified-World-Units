package pcb.uwu.unit.base

import pcb.uwu.util.identity

object RadianUnit
    : AngleUnit(symbol = "rad",
                singularName = "Radian",
                pluralName = "Radians",
                translationToCanonical = identity(),
                translationFromCanonical = identity())
