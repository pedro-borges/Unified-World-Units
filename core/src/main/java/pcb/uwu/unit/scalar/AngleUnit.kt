package pcb.uwu.unit.scalar

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class AngleUnit protected constructor()
    : BaseUnit(0, "rad", "Radian", "Radians", Function.identity(), Function.identity())
{
    override val unitCounter: UnitCounter
        get() = UnitCounter()
    override val baseUnitType = AngleUnit::class.java
}