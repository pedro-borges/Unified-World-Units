package pcb.uwu.unit.base

import pcb.uwu.utils.identity

object RadianUnit
    : AngleUnit(symbol = "rad",
                singularName = "Radian",
                pluralName = "Radians",
                translationToCanonical = identity(),
                translationFromCanonical = identity())
