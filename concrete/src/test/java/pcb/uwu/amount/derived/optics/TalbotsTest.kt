package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Seconds

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