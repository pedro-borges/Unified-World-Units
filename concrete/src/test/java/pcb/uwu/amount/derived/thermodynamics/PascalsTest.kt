package pcb.uwu.amount.derived.thermodynamics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER
import java.math.MathContext.DECIMAL64

class PascalsTest
{
    @Test
    fun multipliedByVolume() =
        assertEquals("27 J",
                     Pascals(9).multipliedBy(Volume(amount = 3, unit = CUBIC_METER), DECIMAL64).toString())

    @Test
    fun multipliedByArea() =
        assertEquals("18 N",
                     Pascals(9).multipliedBy(Area(amount = 2, unit = SquareMeterUnit.SQUARE_METER), DECIMAL64).toString())

}