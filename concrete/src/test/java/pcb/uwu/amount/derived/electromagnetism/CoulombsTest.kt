package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude.MICRO
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class CoulombsTest
{
    @Test
    fun dividedByTime() =
        assertEquals(expected = "0.002 A",
                     actual = (Coulombs(50, MILLI) * Seconds(25)).toString())

    @Test
    fun dividedByElectricCurrent() =
        assertEquals(expected = "25 s",
                     actual = (Coulombs(50, MILLI) * Amperes(2, MILLI)).toString())

    @Test
    fun dividedByElectricCapacitance() =
        assertEquals(expected = "125 V",
                     actual = (Coulombs(50, MILLI) * Farads(400, MICRO)).toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals(expected = "0.0004 F",
                     actual = (Coulombs(50, MILLI) * Volts(125)).toString())

    @Test
    fun multipliedByElectricPotential() =
        assertEquals(expected = "5 J",
                     actual = (Coulombs(50, MILLI) / Volts(100)).toString())
}