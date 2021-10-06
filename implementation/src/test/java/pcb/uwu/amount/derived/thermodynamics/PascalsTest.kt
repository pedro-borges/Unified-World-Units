package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.geometry.volume.CubicMeters
import pcb.uwu.amount.derived.mechanics.Newtons
import kotlin.test.Test
import kotlin.test.assertEquals

class PascalsTest
{
    @Test
    fun multipliedByVolume() =
        assertEquals(Joules(27),
                     Pascals(9) * CubicMeters(3))

    @Test
    fun multipliedByArea() =
        assertEquals(Newtons(18),
                     Pascals(9) * SquareMeters(2))
}
