package pcb.uwu.amount.derived.thermodynamics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude.MILLI
import java.math.MathContext.DECIMAL64

class WattsTest
{
    @Test
    fun multipliedByTime() =
        assertEquals("300 J",
                     Watts(20).multipliedBy(Seconds(15), DECIMAL64).toString())

    @Test
    fun dividedByElectricCurrent() =
        assertEquals("200 V",
                     Watts(20).dividedBy(Amperes(100, MILLI), DECIMAL64).toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals("0.1 A",
                     Watts(20).dividedBy(Volts(200), DECIMAL64).toString())
}