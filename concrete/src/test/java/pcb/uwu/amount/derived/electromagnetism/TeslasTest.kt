package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER

class TeslasTest
{
    @Test
    fun multipliedByArea() =
        assertEquals("4 Wb",
                     Teslas(2).times(Area(amount = 2, unit = SQUARE_METER)).toString())

}