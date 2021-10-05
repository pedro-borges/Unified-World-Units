package pcb.uwu.unit.base

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.utils.identity


object ScalarUnit
    : BaseUnit(precedence = 0,
               symbol = "",
               singularName = "",
               pluralName = "",
               translationToCanonical = identity(),
               translationFromCanonical = identity())
{
    override val unitCounter
        get() = UnitCounter()
    override val baseUnitType = ScalarUnit::class.java
}