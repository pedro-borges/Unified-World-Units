package pcb.uwu.unit.base

import java.math.BigDecimal
import java.util.function.Function.identity

object MoleUnit
    : AmountOfSubstanceUnit(symbol = "mol",
                            singularName = "mole",
                            pluralName = "moles",
                            translationToCanonical = identity(),
                            translationFromCanonical = identity())
{
    val AVOGADRO_NUMBER = BigDecimal("6.02214076E23")
}