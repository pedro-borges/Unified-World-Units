package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MICRO
import kotlin.test.Test
import kotlin.test.assertEquals

class FaradsTest
{
    @Test
    fun multipliedByElectricPotential() =
        assertEquals(expected = Coulombs(0.002),
                     actual = Farads(100, MICRO) * Volts(20))

    @Test
    fun multipliedByElectricResistance() =
        assertEquals(expected = Seconds(0.2),
                     actual = Farads(100, MICRO) * Ohms(2, KILO))
}