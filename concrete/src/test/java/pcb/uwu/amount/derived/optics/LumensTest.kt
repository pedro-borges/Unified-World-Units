package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.scalar.Steradians
import java.math.MathContext.DECIMAL64

class LumensTest
{
    @Test
    fun dividedBySolidAngle() =
        assertEquals("11 cd",
                     Lumens(22).dividedBy(Steradians(2), DECIMAL64).toString())

    @Test
    fun dividedByLuminousIntensity() =
        assertEquals("2 sr",
                     Lumens(22).dividedBy(Candelas(11), DECIMAL64).toString())

    @Test
    fun dividedByArea() =
        assertEquals("2 lx",
                     Lumens(22).dividedBy(SquareMeters(11), DECIMAL64).toString())

    @Test
    fun dividedByIlluminance() =
        assertEquals("11 m²",
                     Lumens(22).dividedBy(Lux(2), DECIMAL64).toString())

    @Test
    fun multipliedByTime() =
        assertEquals("66 T",
                     Lumens(22).multipliedBy(Seconds(3), DECIMAL64).toString())

}