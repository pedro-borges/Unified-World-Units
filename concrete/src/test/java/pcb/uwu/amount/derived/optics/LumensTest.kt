package pcb.uwu.amount.derived.optics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.scalar.Steradians

class LumensTest
{
    @Test
    fun dividedBySolidAngle() =
        assertEquals("11 cd",
                     Lumens(22).div(Steradians(2)).toString())

    @Test
    fun dividedByLuminousIntensity() =
        assertEquals("2 sr",
                     Lumens(22).div(Candelas(11)).toString())

    @Test
    fun dividedByArea() =
        assertEquals("2 lx",
                     Lumens(22).div(SquareMeters(11)).toString())

    @Test
    fun dividedByIlluminance() =
        assertEquals("11 m²",
                     Lumens(22).div(Lux(2)).toString())

    @Test
    fun multipliedByTime() =
        assertEquals("66 T",
                     Lumens(22).times(Seconds(3)).toString())

}