package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude.MICRO
import pcb.uwu.core.Magnitude.MILLI
import java.math.MathContext.DECIMAL64

class CoulombsTest
{
    @Test
    fun dividedByTime() =
        assertEquals("0.002 A",
                     Coulombs(50, MILLI).dividedBy(Seconds(25), DECIMAL64).toString())

    @Test
    fun dividedByElectricCurrent() =
        assertEquals("25 s",
                     Coulombs(50, MILLI).dividedBy(Amperes(2, MILLI), DECIMAL64)
                         .toString())

    @Test
    fun dividedByElectricCapacitance() =
        assertEquals("125 V",
                     Coulombs(50, MILLI).dividedBy(Farads(400, MICRO), DECIMAL64)
                         .toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals("0.0004 F",
                     Coulombs(50, MILLI).dividedBy(Volts(125), DECIMAL64).toString())

    @Test
    fun multipliedByElectricPotential() =
        assertEquals("5 J",
                     Coulombs(50, MILLI).multipliedBy(Volts(100), DECIMAL64).toString())
}