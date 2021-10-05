package pcb.uwu.amount.derived.area

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lux
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.core.Magnitude.*

class SquareMetersTest
{
    @Test
    fun circleFactory()
    {
        assertEquals("0.03141592653589793115997963468544185 m²",
                     SquareMeters.FOR.circle(Meters(1, DECI)).toString())
        assertEquals("3.141592653589793115997963468544185 m²",
                     SquareMeters.FOR.circle(Meters(1)).toString())
        assertEquals("314.1592653589793115997963468544185 m²",
                     SquareMeters.FOR.circle(Meters(1, DEKA)).toString())
    }

    @Test
    fun squareFactory()
    {
        assertEquals("0.01 m²",
                     SquareMeters.FOR.square(Meters(1, DECI)).toString())
        assertEquals("1 m²",
                     SquareMeters.FOR.square(Meters(1)).toString())
        assertEquals("100 m²",
                     SquareMeters.FOR.square(Meters(1, DEKA)).toString())
    }

    @Test
    fun multipliedByLuminance() =
        assertEquals("2 cd",
                     SquareMeters(500, MILLI).times(Nits(4)).toString())

    @Test
    fun multipliedByIlluminance() =
        assertEquals("2 lm",
                     SquareMeters(500, MILLI).times(Lux(4)).toString())

}