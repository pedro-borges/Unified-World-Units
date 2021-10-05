package pcb.uwu.amount.derived.area

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lux
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.core.Magnitude.*
import java.math.MathContext.DECIMAL64

class SquareMetersTest
{
    @Test
    fun circleFactory()
    {
        assertEquals("0.03141592653589793 m²",
                     SquareMeters.FOR.circle(Meters(1, DECI), DECIMAL64).toString())
        assertEquals("3.141592653589793 m²",
                     SquareMeters.FOR.circle(Meters(1), DECIMAL64).toString())
        assertEquals("314.1592653589793 m²",
                     SquareMeters.FOR.circle(Meters(1, DEKA), DECIMAL64).toString())
    }

    @Test
    fun squareFactory()
    {
        assertEquals("0.01 m²",
                     SquareMeters.FOR.square(Meters(1, DECI), DECIMAL64).toString())
        assertEquals("1 m²",
                     SquareMeters.FOR.square(Meters(1), DECIMAL64).toString())
        assertEquals("100 m²",
                     SquareMeters.FOR.square(Meters(1, DEKA), DECIMAL64).toString())
    }

    @Test
    fun multipliedByLuminance() =
        assertEquals("2 cd",
                     SquareMeters(500, MILLI).multipliedBy(Nits(4), DECIMAL64).toString())

    @Test
    fun multipliedByIlluminance() =
        assertEquals("2 lm",
                     SquareMeters(500, MILLI).multipliedBy(Lux(4), DECIMAL64).toString())

}