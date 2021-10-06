package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Seconds
import kotlin.test.Test
import kotlin.test.assertEquals

class TalbotsTest
{
    @Test
    fun dividedByLuminousFlux() =
        assertEquals(Seconds(10),
                     Talbots(50) / Lumens(5))

    @Test
    fun dividedByTime() =
        assertEquals(Lumens(5),
                     Talbots(50) / Seconds(10))
}
