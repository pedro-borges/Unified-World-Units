package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MICRO
import kotlin.test.Test
import kotlin.test.assertEquals

class FaradsTest
{
    @Test
    fun multipliedByElectricPotential() =
        assertEquals(expected = "0.002 C",
                     actual = (Farads(100, MICRO) * Volts(20)).toString())

    @Test
    fun multipliedByElectricResistance() =
        assertEquals(expected = "0.2 s",
                     actual = (Farads(100, MICRO) * Ohms(2, KILO)).toString())
}