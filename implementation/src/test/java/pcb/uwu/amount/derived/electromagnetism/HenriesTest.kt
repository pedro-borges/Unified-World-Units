package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class HenriesTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals(expected = Webbers(0.035),
                     actual = Henries(5) * Amperes(7, MILLI))

}