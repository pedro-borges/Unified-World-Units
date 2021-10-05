package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.InchUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.MinuteUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import java.math.BigDecimal.TEN
import kotlin.test.Test
import kotlin.test.assertEquals

class SpeedTest
{
    @Test
    fun testPlusSpeed() =
        assertEquals("10.254 m⋅s⁻¹",
                     (MetersPerSecond(10) + Length(amount = 10, unit = InchUnit)
                         .div(Time(amount = 1, unit = SecondUnit))).toString())

    @Test
    fun testMinusSpeed() =
        assertEquals("9.746 m⋅s⁻¹",
                     (MetersPerSecond(10) - Length(amount = 10, unit = InchUnit)
                         .div(Time(amount = 1, unit = SecondUnit)))
                         .toString())

    @Test
    fun testtimes() =
        assertEquals("100 m⋅s⁻¹",
                     MetersPerSecond(10).times(TEN).toString())

    @Test
    fun testdiv() =
        assertEquals("1 m⋅s⁻¹",
                     MetersPerSecond(10).div(TEN).toString())

    @Test
    fun testDividedByTime() =
        assertEquals("5 m⋅s⁻²",
                     MetersPerSecond(10).div(Time(amount = 2, unit = SecondUnit)).toString())

    @Test
    fun testMultipliedByTime() =
        assertEquals("1200 m",
                     MetersPerSecond(10).times(Time(amount = 2, unit = MinuteUnit)).toString())

    @Test
    fun testInto()
    {
        assertEquals("1 m⋅s⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(MeterUnit, SecondUnit)).toString())
        assertEquals("60 m⋅min⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(MeterUnit, MinuteUnit)).toString())
        assertEquals("2362.20472440944881889763779527559 in⋅min⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(InchUnit, MinuteUnit)).toString())
        assertEquals("39.37007874015748031496062992125984 in⋅s⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(InchUnit, SecondUnit)).toString())
    }
}