package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class OhmsTest
{
    @Test
    fun multipliedByElectricCurrent() =
        assertEquals(expected = Volts(75),
                     actual = Ohms(1500) * Amperes(50, MILLI))

}