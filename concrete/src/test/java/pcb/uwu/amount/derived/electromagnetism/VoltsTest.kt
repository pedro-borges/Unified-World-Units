package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class VoltsTest
{
    @Test
    fun divideByElectricResistance() =
        assertEquals("0.02 A",
                     Volts(10).div(Ohms(500)).toString())

    @Test
    fun divideByElectricCurrent() =
        assertEquals("500 Ω",
                     Volts(10).div(Amperes(20, MILLI)).toString())

    @Test
    fun multiplyByElectricCharge() =
        assertEquals("2 J",
                     Volts(10).times(Coulombs(200, MILLI)).toString())
}