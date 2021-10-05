package pcb.uwu.unit.base

import pcb.uwu.core.Amount

object PercentageUnit : ScalarUnit(symbol = "%",
                                   singularName = "percent",
                                   pluralName = "percent",
                                   translationToCanonical = { amount: Amount -> amount / 100 },
                                   translationFromCanonical = { amount: Amount -> amount * 100 })
