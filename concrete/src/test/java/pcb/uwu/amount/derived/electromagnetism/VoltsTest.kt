package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import java.math.MathContext.DECIMAL64

class VoltsTest
{
    @Test
    fun divideByElectricResistance() =
        assertEquals("0.02 A",
                     Volts(10).dividedBy(Ohms(500), DECIMAL64).toString())

    @Test
    fun divideByElectricCurrent() =
        assertEquals("500 Ω",
                     Volts(10).dividedBy(Amperes(20, MILLI), DECIMAL64).toString())

    @Test
    fun multiplyByElectricCharge() =
        assertEquals("2 J",
                     Volts(10).multipliedBy(Coulombs(200, MILLI), DECIMAL64).toString())
}