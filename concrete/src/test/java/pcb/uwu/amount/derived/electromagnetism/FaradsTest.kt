package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MICRO
import java.math.MathContext.DECIMAL64

class FaradsTest
{
    @Test
    fun multipliedByElectricPotential() =
        assertEquals("0.002 C",
                     Farads(100, MICRO).multipliedBy(Volts(20), DECIMAL64).toString())

    @Test
    fun multipliedByElectricResistance() =
        assertEquals("0.2 s",
                     Farads(100, MICRO).multipliedBy(Ohms(2, KILO), DECIMAL64).toString())
}