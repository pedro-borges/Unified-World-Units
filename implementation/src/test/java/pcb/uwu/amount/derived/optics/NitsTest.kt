package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import kotlin.test.Test
import kotlin.test.assertEquals

class NitsTest
{
    @Test
    fun multipliedByArea() =
        assertEquals(expected = Candelas(20),
                     actual = Nits(4) * SquareMeters(5))

}