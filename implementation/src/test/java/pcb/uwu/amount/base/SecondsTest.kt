package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.optics.Lumens
import pcb.uwu.amount.derived.optics.Talbots
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.amount.derived.thermodynamics.Watts
import kotlin.test.Test
import kotlin.test.assertEquals

class SecondsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals(expected = Coulombs(35),
                     actual = Seconds(7) * Amperes(5))

    @Test
    fun multipliedByPower() =
        assertEquals(expected = Joules(35),
                     actual = Seconds(7) * Watts(5))

    @Test
    fun multipliedByLuminousFlux() =
        assertEquals(expected = Talbots(35),
                     actual = Seconds(7) * Lumens(5))
}