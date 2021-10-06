package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude.MICRO
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class CoulombsTest
{
    @Test
    fun dividedByTime() =
        assertEquals(expected = Amperes(0.002),
                     actual = Coulombs(50, MILLI) / Seconds(25))

    @Test
    fun dividedByElectricCurrent() =
        assertEquals(expected = Seconds(25),
                     actual = Coulombs(50, MILLI) / Amperes(2, MILLI))

    @Test
    fun dividedByElectricCapacitance() =
        assertEquals(expected = Volts(125),
                     actual = Coulombs(50, MILLI) / Farads(400, MICRO))

    @Test
    fun dividedByElectricPotential() =
        assertEquals(expected = Farads(0.0004),
                     actual = Coulombs(50, MILLI) / Volts(125))

    @Test
    fun multipliedByElectricPotential() =
        assertEquals(expected = Joules(5),
                     actual = Coulombs(50, MILLI) * Volts(100))
}
