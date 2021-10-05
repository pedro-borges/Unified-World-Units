package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI

class HenriesTest
{
    @Test
    fun multipliedByElectricCurrent()
    {
        assertEquals("0.035 Wb",
                     henries.times(Amperes(7, MILLI)).toString())
    }

    companion object
    {
        private val henries = Henries(5)
    }
}