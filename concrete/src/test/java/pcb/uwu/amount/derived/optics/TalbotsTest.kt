package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Seconds
import kotlin.test.Test
import kotlin.test.assertEquals

class TalbotsTest
{
    @Test
    fun dividedByLuminousFlux() =
        assertEquals("10 s",
                     Talbots(50).div(Lumens(5)).toString())

    @Test
    fun dividedByTime() =
        assertEquals("5 lm",
                     Talbots(50).div(Seconds(10)).toString())

}