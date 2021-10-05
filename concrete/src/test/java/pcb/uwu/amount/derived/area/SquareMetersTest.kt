package pcb.uwu.amount.derived.area

import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lux
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.core.Magnitude.DECI
import pcb.uwu.core.Magnitude.DEKA
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class SquareMetersTest
{
    @Test
    fun circleFactory()
    {
        assertEquals(expected = "0.03141592653589793115997963468544185 m²",
                     actual = SquareMeters.FOR.circle(Meters(1, DECI)).toString())
        assertEquals(expected = "3.141592653589793115997963468544185 m²",
                     actual = SquareMeters.FOR.circle(Meters(1)).toString())
        assertEquals(expected = "314.1592653589793115997963468544185 m²",
                     actual = SquareMeters.FOR.circle(Meters(1, DEKA)).toString())
    }

    @Test
    fun squareFactory()
    {
        assertEquals(expected = "0.01 m²",
                     actual = SquareMeters.FOR.square(Meters(1, DECI)).toString())
        assertEquals(expected = "1 m²",
                     actual = SquareMeters.FOR.square(Meters(1)).toString())
        assertEquals(expected = "100 m²",
                     actual = SquareMeters.FOR.square(Meters(1, DEKA)).toString())
    }

    @Test
    fun multipliedByLuminance() =
        assertEquals(expected = "2 cd",
                     actual = (SquareMeters(500, MILLI) * Nits(4)).toString())

    @Test
    fun multipliedByIlluminance() =
        assertEquals(expected = "2 lm",
                     actual = (SquareMeters(500, MILLI) * Lux(4)).toString())

}