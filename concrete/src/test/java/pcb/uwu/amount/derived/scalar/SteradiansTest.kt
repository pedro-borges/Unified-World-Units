package pcb.uwu.amount.derived.scalar

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.optics.Lumens
import kotlin.test.Test
import kotlin.test.assertEquals

class SteradiansTest
{
    @Test
    fun multipliedByLuminousIntensity() =
        assertEquals(Lumens(39),
                     Steradians(13).times(Candelas(3)))

}