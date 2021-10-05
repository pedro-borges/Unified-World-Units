package pcb.uwu.unit.base

import pcb.uwu.utils.identity

object KiloGramUnit
    : MassUnit(symbol = "Kg",
               singularName = "kilogram",
               pluralName = "kilograms",
               translationToCanonical = identity(),
               translationFromCanonical = identity())
