package pcb.uwu.unit.base

import pcb.uwu.core.Amount

object PermillageUnit : ScalarUnit(symbol = "‰",
                                   singularName = "permillage",
                                   pluralName = "permillage",
                                   translationToCanonical = { amount: Amount -> amount / 1000 },
                                   translationFromCanonical = { amount: Amount -> amount * 1000 })
