package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import java.math.MathContext.DECIMAL64

class NitsTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("20 cd",
                     Nits(4).multipliedBy(SquareMeters(5), DECIMAL64).toString())

}