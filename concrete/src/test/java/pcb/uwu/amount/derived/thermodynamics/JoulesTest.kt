package pcb.uwu.amount.derived.thermodynamics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.electromagnetism.Coulombs
import pcb.uwu.amount.derived.electromagnetism.Volts
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.mechanics.Newtons
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit

class JoulesTest
{
    @Test
    fun dividedByVolume() =
        assertEquals("40 Pa",
                     Joules(200).div(Volume(amount = 5, unit = CubicMeterUnit)).toString())

    @Test
    fun dividedByPressure() =
        assertEquals("5 m³",
                     Joules(200).div(Pascals(40)).toString())

    @Test
    fun dividedByPower() =
        assertEquals("5 s",
                     Joules(200).div(Watts(40)).toString())

    @Test
    fun dividedByTime() =
        assertEquals("40 W",
                     Joules(200).div(Seconds(5)).toString())

    @Test
    fun dividedByLength() =
        assertEquals("5 N",
                     Joules(200).div(Meters(40)).toString())

    @Test
    fun dividedByForce() =
        assertEquals("40 m",
                     Joules(200).div(Newtons(5)).toString())

    @Test
    fun dividedByElectricCharge() =
        assertEquals("5 V",
                     Joules(200).div(Coulombs(40)).toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals("40 C",
                     Joules(200).div(Volts(5)).toString())

}