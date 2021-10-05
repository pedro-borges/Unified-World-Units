package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class TeslasTest
{
    @Test
    fun multipliedByArea() =
        assertEquals(expected = Webbers(4),
                     actual = Teslas(2) * Area(amount = 2, unit = SquareMeterUnit))

}