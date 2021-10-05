package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI

class OhmsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals("75 V",
                     Ohms(1500).times(Amperes(50, MILLI)).toString())

}