package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.Ohms
import pcb.uwu.amount.derived.electromagnetism.Siemens
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class AmperesTest
{
    @Test
    fun multipliedByTime() =
        assertEquals(expected = "0.24 C",
                     actual = (Amperes(2, MILLI) * Minutes(2)).toString())

    @Test
    fun multipliedByElectricResistance() =
        assertEquals(expected = "4 V",
                     actual = (Amperes(2, MILLI) * Ohms(2, KILO)).toString())

    @Test
    fun dividedByElectricalPotential() =
        assertEquals(expected = "2 S",
                     actual = (Amperes(2, MILLI) / Volts(1, MILLI)).toString())

    @Test
    fun dividedByElectricalConductance() =
        assertEquals(expected = "0.001 V",
                     actual = (Amperes(2, MILLI) / Siemens(2)).toString())
}