package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude.MICRO
import pcb.uwu.core.Magnitude.MILLI

class CoulombsTest
{
    @Test
    fun dividedByTime() =
        assertEquals("0.002 A",
                     Coulombs(50, MILLI).div(Seconds(25)).toString())

    @Test
    fun dividedByElectricCurrent() =
        assertEquals("25 s",
                     Coulombs(50, MILLI).div(Amperes(2, MILLI))
                         .toString())

    @Test
    fun dividedByElectricCapacitance() =
        assertEquals("125 V",
                     Coulombs(50, MILLI).div(Farads(400, MICRO))
                         .toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals("0.0004 F",
                     Coulombs(50, MILLI).div(Volts(125)).toString())

    @Test
    fun multipliedByElectricPotential() =
        assertEquals("5 J",
                     Coulombs(50, MILLI).times(Volts(100)).toString())
}