package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.core.Magnitude.MILLI
import kotlin.test.Test
import kotlin.test.assertEquals

class WattsTest
{
    @Test
    fun multipliedByTime() =
        assertEquals(Joules(300),
                     Watts(20) * Seconds(15))

    @Test
    fun dividedByElectricCurrent() =
        assertEquals(Volts(200),
                     Watts(20) / Amperes(100, MILLI))

    @Test
    fun dividedByElectricPotential() =
        assertEquals(Amperes(0.1),
                     Watts(20) / Volts(200))
}
