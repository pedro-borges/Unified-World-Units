package pcb.uwu.amount.base

import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.thermodynamics.Watts
import kotlin.test.Test
import kotlin.test.assertEquals

class SecondsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals(expected = "35 C",
                     actual = (Seconds(7) * Amperes(5)).toString())

    @Test
    fun multipliedByPower() =
        assertEquals(expected = "35 J",
                     actual = (Seconds(7) * Watts(5)).toString())

    @Test
    fun multipliedByLuminousFlux() =
        assertEquals(expected = "35 T",
                     actual = (Seconds(7) * Lumens(5)).toString())
}