package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.thermodynamics.Watts

class SecondsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals("35 C",
                     Seconds(7).times(Amperes(5)).toString())

    @Test
    fun multipliedByPower() =
        assertEquals("35 J",
                     Seconds(7).times(Watts(5)).toString())

    @Test
    fun multipliedByLuminousFlux() =
        assertEquals("35 T",
                     Seconds(7).times(Lumens(5)).toString())
}