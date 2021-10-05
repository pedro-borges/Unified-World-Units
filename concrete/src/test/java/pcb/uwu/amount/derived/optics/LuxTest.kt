package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class LuxTest
{
    @Test
    fun multipliedByArea() =
        assertEquals(expected = "200 lm",
                     actual = Lux(2000).times(SquareMeters(100, MILLI)).toString())

}