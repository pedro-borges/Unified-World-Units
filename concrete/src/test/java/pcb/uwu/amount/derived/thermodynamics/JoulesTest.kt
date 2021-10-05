package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.amount.derived.fundamental.volume.CubicMeters
import pcb.uwu.amount.derived.mechanics.Newtons
import kotlin.test.Test
import kotlin.test.assertEquals

class JoulesTest
{
    @Test
    fun dividedByVolume() =
        assertEquals(Pascals(40),
                     Joules(200) / CubicMeters(5))

    @Test
    fun dividedByPressure() =
        assertEquals(CubicMeters(5),
                     Joules(200) / Pascals(40))

    @Test
    fun dividedByPower() =
        assertEquals(Seconds(5),
                     Joules(200) / Watts(40))

    @Test
    fun dividedByTime() =
        assertEquals(Watts(40),
                     Joules(200) / Seconds(5))

    @Test
    fun dividedByLength() =
        assertEquals(Newtons(5),
                     Joules(200) / Meters(40))

    @Test
    fun dividedByForce() =
        assertEquals(Meters(40),
                     Joules(200) / Newtons(5))

    @Test
    fun dividedByElectricCharge() =
        assertEquals(Volts(5),
                     Joules(200) / Coulombs(40))

    @Test
    fun dividedByElectricPotential() =
        assertEquals(Coulombs(40),
                     Joules(200) / Volts(5))

}