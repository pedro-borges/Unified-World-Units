package pcb.uwu.unit.base

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.util.identity
import kotlin.reflect.KClass


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
    override val baseUnitType: KClass<out BaseUnit> = ScalarUnit::class
}