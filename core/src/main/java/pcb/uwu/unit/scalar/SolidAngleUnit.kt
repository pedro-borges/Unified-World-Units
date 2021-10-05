package pcb.uwu.unit.scalar

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class SolidAngleUnit protected constructor() :
    BaseUnit(0, "sr", "Steradian", "Steradians", Function.identity(), Function.identity())
{
    override val unitCounter: UnitCounter
        get() = UnitCounter()
    override val baseUnitType = SolidAngleUnit::class.java
}