package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Seconds
import java.math.MathContext.DECIMAL64

class TalbotsTest
{
    @Test
    fun dividedByLuminousFlux() =
        assertEquals("10 s",
                     Talbots(50).dividedBy(Lumens(5), DECIMAL64).toString())

    @Test
    fun dividedByTime() =
        assertEquals("5 lm",
                     Talbots(50).dividedBy(Seconds(10), DECIMAL64).toString())

}