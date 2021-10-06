package pcb.uwu.amount.base

import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.amount.derived.scalar.Steradians
import kotlin.test.Test
import kotlin.test.assertEquals

class CandelasTest
{
    @Test
    fun multipliedBySolidAngle() =
        assertEquals(expected = Lumens(54),
                     actual = Candelas(18) * Steradians(3))

    @Test
    fun dividedByArea() =
        assertEquals(expected = Nits(6),
                     actual = Candelas(18) / SquareMeters(3))

    @Test
    fun dividedByLuminance() =
        assertEquals(expected = SquareMeters(3),
                     actual = Candelas(18) / Nits(6))
}
