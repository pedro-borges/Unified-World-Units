package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER
import java.math.MathContext.DECIMAL64

class TeslasTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("4 Wb",
                     Teslas(2).multipliedBy(Area(amount = 2, unit = SQUARE_METER), DECIMAL64).toString())

}