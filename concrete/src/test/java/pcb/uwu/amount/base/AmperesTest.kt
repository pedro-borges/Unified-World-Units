package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.electromagnetism.Ohms
import pcb.uwu.amount.derived.electromagnetism.Siemens
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MILLI

class AmperesTest
{
    @Test
    fun multipliedByTime() =
        assertEquals("0.24 C",
                     (Amperes(2, MILLI) * Minutes(2)).toString())

    @Test
    fun multipliedByElectricResistance() =
        assertEquals("4 V",
                     (Amperes(2, MILLI) * Ohms(2, KILO)).toString())

    @Test
    fun dividedByElectricalPotential() =
        assertEquals("2 S",
                     (Amperes(2, MILLI) / Volts(1, MILLI)).toString())

    @Test
    fun dividedByElectricalConductance() =
        assertEquals("0.001 V",
                     (Amperes(2, MILLI) / Siemens(2)).toString())
}