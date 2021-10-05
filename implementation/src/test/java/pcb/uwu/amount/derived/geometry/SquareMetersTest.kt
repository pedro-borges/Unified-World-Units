package pcb.uwu.amount.derived.geometry

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lumens
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
        assertEquals(expected = SquareMeters("0.03141592653589793115997963468544185"),
                     actual = SquareMeters.FOR.circle(Meters(1, DECI)))
        assertEquals(expected = SquareMeters("3.141592653589793115997963468544185"),
                     actual = SquareMeters.FOR.circle(Meters(1)))
        assertEquals(expected = SquareMeters("314.1592653589793115997963468544185"),
                     actual = SquareMeters.FOR.circle(Meters(1, DEKA)))
    }

    @Test
    fun squareFactory()
    {
        assertEquals(expected = SquareMeters(0.01),
                     actual = SquareMeters.FOR.square(Meters(1, DECI)))
        assertEquals(expected = SquareMeters(1),
                     actual = SquareMeters.FOR.square(Meters(1)))
        assertEquals(expected = SquareMeters(100),
                     actual = SquareMeters.FOR.square(Meters(1, DEKA)))
    }

    @Test
    fun multipliedByLuminance() =
        assertEquals(expected = Candelas(2),
                     actual = SquareMeters(500, MILLI) * Nits(4))

    @Test
    fun multipliedByIlluminance() =
        assertEquals(expected = Lumens(2),
                     actual = SquareMeters(500, MILLI) * Lux(4))

}