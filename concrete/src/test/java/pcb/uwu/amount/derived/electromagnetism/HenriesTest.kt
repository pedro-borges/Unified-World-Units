package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class HenriesTest
{
    @Test
    fun multipliedByElectricCurrent()
    {
        assertEquals(expected = "0.035 Wb",
                     actual = (henries * Amperes(7, MILLI)).toString())
    }

    companion object
    {
        private val henries = Henries(5)
    }
}