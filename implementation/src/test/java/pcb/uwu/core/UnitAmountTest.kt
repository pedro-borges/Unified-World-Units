package pcb.uwu.core

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.geometry.Volume
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.derived.geometry.CubicMeterUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class UnitAmountTest
{
    @Test
    fun testMajorMajor() =
        assertEquals(expected = Volume(amount = 100, unit = CubicMeterUnit),
                     actual = Meters(1) * Meters(10) * Meters(10))

    @Test
    fun testMinorMajor() =
        assertEquals(expected = Length(amount = 1, unit = MeterUnit),
                     actual = Meters(1) / Amperes(10) * Amperes(10))


    @Test
    fun testMajorMinor()
    {
        assertEquals(expected = Length(amount = 1, unit = MeterUnit),
                     actual = Meters(1) * Amperes(10) / Amperes(10))
    }
}