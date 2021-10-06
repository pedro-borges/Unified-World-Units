package pcb.uwu.core

import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit
import pcb.uwu.util.identity
import kotlin.test.Test
import kotlin.test.assertEquals


class UnitCounterTest
{
    @Test
    fun testObjectCounter()
    {
        var test = UnitCounter()
        assertEquals(0, test[SECOND].count.toLong())
        assertEquals(1, test.major(SECOND).also { test = it }[SECOND].count)
        assertEquals(0, test.minor(SECOND).also { test = it }[SECOND].count)
        assertEquals(-1, test.minor(SECOND).also { test = it }[SECOND].count)
        assertEquals(0, test.major(SECOND).also { test = it }[SECOND].count)
        assertEquals(1, test.major(SECOND).also { test = it }[SECOND].count)
        assertEquals(1, test.major(AMPERE).also { test = it }[AMPERE].count)
        assertEquals(2, test.major(SECOND).also { test = it }[SECOND].count)
        assertEquals(3, test.major(SECOND).also { test = it }[SECOND].count)
        assertEquals(-1, test.minor(KILOGRAM).also { test = it }[KILOGRAM].count)
        assertEquals(3, test.baseUnits.size)
        assertEquals(-1, test[KILOGRAM].count)
        assertEquals(3, test[SECOND].count)
        assertEquals(1, test[AMPERE].count)
        assertEquals(0, test.major(KILOGRAM).also { test = it }[KILOGRAM].count)
        assertEquals(2, test.baseUnits.size)
        assertEquals(3, test[SECOND].count)
        assertEquals(1, test[AMPERE].count)
    }

    companion object
    {
        val SECOND: BaseUnit = TimeUnit("s", "", "", identity(), identity())
        val AMPERE: BaseUnit = ElectricCurrentUnit("A", "", "", identity(), identity())
        val KILOGRAM: BaseUnit = MassUnit("Kg", "", "", identity(), identity())
    }
}
