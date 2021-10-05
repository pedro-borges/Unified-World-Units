package pcb.uwu.unit.base

import java.util.function.Function.identity

object KiloGramUnit
    : MassUnit(symbol = "Kg",
               singularName = "kilogram",
               pluralName = "kilograms",
               translationToCanonical = identity(),
               translationFromCanonical = identity())
