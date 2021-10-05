package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.area.SquareMeters

class NitsTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("20 cd",
                     Nits(4).times(SquareMeters(5)).toString())

}