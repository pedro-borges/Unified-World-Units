package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import java.math.MathContext.DECIMAL64

class HenriesTest
{
    @Test
    fun multipliedByElectricCurrent()
    {
        assertEquals("0.035 Wb",
                     henries.multipliedBy(Amperes(7, MILLI), DECIMAL64).toString())
    }

    companion object
    {
        private val henries = Henries(5)
    }
}