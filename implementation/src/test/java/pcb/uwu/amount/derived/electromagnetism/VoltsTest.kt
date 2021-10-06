package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class VoltsTest
{
    @Test
    fun divideByElectricResistance() =
        assertEquals(expected = Amperes(0.02),
                     actual = Volts(10) / Ohms(500))

    @Test
    fun divideByElectricCurrent() =
        assertEquals(expected = Ohms(500),
                     actual = Volts(10) / Amperes(20, MILLI))

    @Test
    fun multiplyByElectricCharge() =
        assertEquals(expected = Joules(2),
                     actual = Volts(10) * Coulombs(200, MILLI))
}
