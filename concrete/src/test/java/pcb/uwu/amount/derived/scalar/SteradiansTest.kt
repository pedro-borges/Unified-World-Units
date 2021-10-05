package pcb.uwu.amount.derived.scalar

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.optics.Lumens
import kotlin.test.Test
import kotlin.test.assertEquals

class SteradiansTest
{
    @Test
    fun multipliedByLuminousIntensity() =
        assertEquals(expected = Lumens(39),
                     actual = Steradians(13) * Candelas(3))

}