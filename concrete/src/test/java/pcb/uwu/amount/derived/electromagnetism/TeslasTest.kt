package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.unit.derived.area.SquareMeterUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class TeslasTest
{
    @Test
    fun multipliedByArea() =
        assertEquals(expected = "4 Wb",
                     actual = (Teslas(2) * Area(amount = 2, unit = SquareMeterUnit)).toString())

}