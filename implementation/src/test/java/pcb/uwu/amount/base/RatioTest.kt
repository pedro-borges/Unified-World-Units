package pcb.uwu.amount.base

import pcb.uwu.core.Amount
import pcb.uwu.unit.base.ScalarUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class RatioTest
{
    @Test
    fun ratioIs1() =
        assertEquals(expected = Amount(1),
                     actual = (Ratio(1) to ScalarUnit()).amount)
}
