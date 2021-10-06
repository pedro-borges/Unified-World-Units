package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.Inches
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Minutes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.unit.base.InchUnit
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.MinuteUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class SpeedTest
{
    @Test
    fun testPlusSpeed() =
        assertEquals(expected = MetersPerSecond(10.254),
                     actual = MetersPerSecond(10) + Inches(10) / Seconds(amount = 1))

    @Test
    fun testMinusSpeed() =
        assertEquals(expected = MetersPerSecond(9.746),
                     actual = MetersPerSecond(10) - Inches(10) / Seconds(1))

    @Test
    fun testDividedByTime() =
        assertEquals(expected = MetersPerSquareSecond(5),
                     actual = MetersPerSecond(10) / Seconds(2))

    @Test
    fun testMultipliedByTime() =
        assertEquals(expected = Meters(1200),
                     actual = MetersPerSecond(10) * Minutes(2))

    @Test
    fun testTo()
    {
        assertEquals(expected = Speed(amount = 1,
                                      unit = SpeedUnit(MeterUnit, SecondUnit)),
                     actual = MetersPerSecond(1) to SpeedUnit(MeterUnit, SecondUnit))

        assertEquals(expected = Speed(amount = 60,
                                      unit = SpeedUnit(MeterUnit, MinuteUnit)),
                     actual = MetersPerSecond(1) to SpeedUnit(MeterUnit, MinuteUnit))

        assertEquals(expected = Speed(amount = "2362.20472440944881889763779527559",
                                      unit = SpeedUnit(InchUnit, MinuteUnit)),
                     actual = MetersPerSecond(1) to SpeedUnit(InchUnit, MinuteUnit))

        assertEquals(expected = Speed(amount = "39.37007874015748031496062992125984",
                                      unit = SpeedUnit(InchUnit, SecondUnit)),
                     actual = MetersPerSecond(1) to SpeedUnit(InchUnit, SecondUnit))
    }
}
