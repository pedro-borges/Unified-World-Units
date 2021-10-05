package pcb.uwu.unit.base

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.UnitCounter
import pcb.uwu.unit.base.ScalarUnit
import java.util.function.Function.identity

class ScalarUnit private constructor()
    : BaseUnit(0, "", "", "", identity(), identity())
{
    override val unitCounter
        get() = UnitCounter()
    override val baseUnitType = ScalarUnit::class.java

    companion object
    {
        @JvmField
        val SCALAR = ScalarUnit()
    }
}