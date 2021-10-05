package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.unit.base.ElectricCurrentUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.unit.base.TimeUnit

class UnitCounterTest
{
    @Test
    fun testObjectCounter()
    {
        var test = UnitCounter()
        assertEquals(0, test[SECOND].count.toLong())
        assertEquals(1, test.major(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(0, test.minor(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(-1, test.minor(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(0, test.major(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(1, test.major(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(1, test.major(AMPERE).also { test = it }[AMPERE].count.toLong())
        assertEquals(2, test.major(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(3, test.major(SECOND).also { test = it }[SECOND].count.toLong())
        assertEquals(-1, test.minor(KILOGRAM).also { test = it }[KILOGRAM].count.toLong())
        assertEquals(3, test.baseUnits.size.toLong())
        assertEquals(-1, test[KILOGRAM].count.toLong())
        assertEquals(3, test[SECOND].count.toLong())
        assertEquals(1, test[AMPERE].count.toLong())
        assertEquals(0, test.major(KILOGRAM).also { test = it }[KILOGRAM].count.toLong())
        assertEquals(2, test.baseUnits.size.toLong())
        assertEquals(3, test[SECOND].count.toLong())
        assertEquals(1, test[AMPERE].count.toLong())
    }

    companion object
    {
        val SECOND: BaseUnit = TimeUnit("s", "", "", null, null)
        val AMPERE: BaseUnit = ElectricCurrentUnit("A", "", "", null, null)
        val KILOGRAM: BaseUnit = MassUnit("Kg", "", "", null, null)
    }
}