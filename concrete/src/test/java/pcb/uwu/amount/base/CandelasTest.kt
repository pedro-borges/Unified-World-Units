package pcb.uwu.amount.base

import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.amount.derived.scalar.Steradians
import kotlin.test.Test
import kotlin.test.assertEquals

class CandelasTest
{
    @Test
    fun multipliedBySolidAngle() =
        assertEquals(expected = "54 lm",
                     actual = (Candelas(18) * Steradians(3)).toString())

    @Test
    fun dividedByArea() =
        assertEquals(expected = "6 nit",
                     actual = (Candelas(18) / SquareMeters(3)).toString())

    @Test
    fun dividedByLuminance() =
        assertEquals(expected = "3 m²",
                     actual = (Candelas(18) / Nits(6)).toString())
}