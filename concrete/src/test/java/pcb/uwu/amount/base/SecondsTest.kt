package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.thermodynamics.Watts
import java.math.MathContext.DECIMAL64

class SecondsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals("35 C",
                     Seconds(7).multipliedBy(Amperes(5), DECIMAL64).toString())

    @Test
    fun multipliedByPower() =
        assertEquals("35 J",
                     Seconds(7).multipliedBy(Watts(5), DECIMAL64).toString())

    @Test
    fun multipliedByLuminousFlux() =
        assertEquals("35 T",
                     Seconds(7).multipliedBy(Lumens(5), DECIMAL64).toString())
}