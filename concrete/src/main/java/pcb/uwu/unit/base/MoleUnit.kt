package pcb.uwu.unit.base

import pcb.uwu.utils.identity
import java.math.BigDecimal

object MoleUnit
    : AmountOfSubstanceUnit(symbol = "mol",
                            singularName = "mole",
                            pluralName = "moles",
                            translationToCanonical = identity(),
                            translationFromCanonical = identity())
{
    val AVOGADRO_NUMBER = BigDecimal("6.02214076E23")
}