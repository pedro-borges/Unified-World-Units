package pcb.uwu.unit.base

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function.identity

open class AngleUnit
    : BaseUnit(0, "rad", "Radian", "Radians", identity(), identity())
{
    override val unitCounter: UnitCounter
        get() = UnitCounter()
    override val baseUnitType = AngleUnit::class.java
}