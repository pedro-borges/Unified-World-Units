package pcb.uwu.amount.base

import pcb.uwu.core.Amount
import pcb.uwu.unit.base.ScalarUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class PercentageTest
{
    @Test
    fun percentageIs100() =
        assertEquals(expected = Amount(0.01),
                     actual = (Percentage(1) to ScalarUnit()).amount)
}
