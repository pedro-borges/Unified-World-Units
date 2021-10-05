package pcb.uwu.amount.base

import pcb.uwu.core.Amount
import pcb.uwu.unit.base.ScalarUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class PermillageTest
{
    @Test
    fun percentageIs1000() =
        assertEquals(expected = Amount(0.001),
                     actual = (Permillage(1) to ScalarUnit()).amount)
}