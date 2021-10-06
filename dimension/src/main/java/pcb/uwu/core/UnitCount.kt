package pcb.uwu.core

import pcb.uwu.unit.base.ScalarUnit
import pcb.uwu.util.hash

class UnitCount(val unit: BaseUnit, val count: Int)
{
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?) =
        if (that is UnitCount)
        {
            unit == that.unit &&
                    count == that.count
        }
        else false

    override fun hashCode() =
        hash(unit, count)

    companion object
    {
        val EMPTY_BASE_UNIT_COUNT = UnitCount(ScalarUnit(), 0)
    }
}
