package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MICRO

class FaradsTest
{
    @Test
    fun multipliedByElectricPotential() =
        assertEquals("0.002 C",
                     Farads(100, MICRO).times(Volts(20)).toString())

    @Test
    fun multipliedByElectricResistance() =
        assertEquals("0.2 s",
                     Farads(100, MICRO).times(Ohms(2, KILO)).toString())
}