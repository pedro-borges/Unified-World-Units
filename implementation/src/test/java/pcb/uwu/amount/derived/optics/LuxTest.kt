package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class LuxTest
{
    @Test
    fun multipliedByArea() =
        assertEquals(expected = Lumens(200),
                     actual = Lux(2000) * SquareMeters(100, MILLI))
}
