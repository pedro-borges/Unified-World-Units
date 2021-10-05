package pcb.uwu.amount.base

import pcb.uwu.amount.derived.electromagnetism.Coulombs
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
        assertEquals(expected = Coulombs(0.24),
                     actual = Amperes(2, MILLI) * Minutes(2))

    @Test
    fun multipliedByElectricResistance() =
        assertEquals(expected = Volts(4),
                     actual = Amperes(2, MILLI) * Ohms(2, KILO))

    @Test
    fun dividedByElectricalPotential() =
        assertEquals(expected = Siemens(2),
                     actual = Amperes(2, MILLI) / Volts(1, MILLI))

    @Test
    fun dividedByElectricalConductance() =
        assertEquals(expected = Volts("0.001"),
                     actual = Amperes(2, MILLI) / Siemens(2))
}