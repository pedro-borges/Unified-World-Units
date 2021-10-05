package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import java.math.MathContext.DECIMAL64

class OhmsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals("75 V",
                     Ohms(1500).multipliedBy(Amperes(50, MILLI), DECIMAL64).toString())

}