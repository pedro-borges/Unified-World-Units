package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import kotlin.test.Test
import kotlin.test.assertEquals

class NitsTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("20 cd",
                     Nits(4).times(SquareMeters(5)).toString())

}