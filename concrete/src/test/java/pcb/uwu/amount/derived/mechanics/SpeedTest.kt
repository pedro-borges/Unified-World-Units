package pcb.uwu.amount.derived.mechanics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.InchUnit.INCH
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.base.MinuteUnit.MINUTE
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.mechanics.SpeedUnit
import java.math.BigDecimal.TEN

class SpeedTest
{
    @Test
    fun testPlusSpeed() =
        assertEquals("10.254 m⋅s⁻¹",
                     (MetersPerSecond(10) + Length(amount = 10, unit = INCH)
                                                  .div(Time(amount = 1, unit = SECOND))).toString())

    @Test
    fun testMinusSpeed() =
        assertEquals("9.746 m⋅s⁻¹",
                     (MetersPerSecond(10) - Length(amount = 10, unit = INCH)
                         .div(Time(amount = 1, unit = SECOND)))
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
                     MetersPerSecond(10).div(Time(amount = 2, unit = SECOND)).toString())

    @Test
    fun testMultipliedByTime() =
        assertEquals("1200 m",
                     MetersPerSecond(10).times(Time(amount = 2, unit = MINUTE)).toString())

    @Test
    fun testInto()
    {
        assertEquals("1 m⋅s⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(METER, SECOND)).toString())
        assertEquals("60 m⋅min⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(METER, MINUTE)).toString())
        assertEquals("2362.20472440944881889763779527559 in⋅min⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(INCH, MINUTE)).toString())
        assertEquals("39.37007874015748031496062992125984 in⋅s⁻¹",
                     (MetersPerSecond(1) to SpeedUnit(INCH, SECOND)).toString())
    }
}