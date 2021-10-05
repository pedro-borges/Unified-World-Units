package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.core.Magnitude.MILLI

class LuxTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("200 lm",
                     Lux(2000).times(SquareMeters(100, MILLI)).toString())

}