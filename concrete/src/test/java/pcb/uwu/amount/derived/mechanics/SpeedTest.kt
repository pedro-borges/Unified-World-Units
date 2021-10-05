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
import java.math.MathContext.DECIMAL64

class SpeedTest
{

    @Test
    fun testPlusSpeed() =
        assertEquals("10.254 s⁻¹⋅m",
                     (MetersPerSecond(10) + Length(value = 10, unit = INCH)
                                                  .dividedBy(Time(value = 1, unit = SECOND), DECIMAL64)).toString())

    @Test
    fun testMinusSpeed() =
        assertEquals("9.746 s⁻¹⋅m",
                     (MetersPerSecond(10) - Length(value = 10, unit = INCH)
                         .dividedBy(Time(value = 1, unit = SECOND), DECIMAL64))
                         .toString())

    @Test
    fun testMultipliedBy() =
        assertEquals("100 s⁻¹⋅m",
                     MetersPerSecond(10).multiply(TEN, DECIMAL64).toString())

    @Test
    fun testDividedBy() =
        assertEquals("1 s⁻¹⋅m",
                     MetersPerSecond(10).div(TEN, DECIMAL64).toString())

    @Test
    fun testDividedByTime() =
        assertEquals("5 s⁻²⋅m",
                     MetersPerSecond(10).dividedBy(Time(value = 2, unit = SECOND), DECIMAL64).toString())

    @Test
    fun testMultipliedByTime() =
        assertEquals("1200 m",
                     MetersPerSecond(10).multipliedBy(Time(value = 2, unit = MINUTE), DECIMAL64).toString())

    @Test
    fun testIn()
    {
        assertEquals("10 s⁻¹⋅m",
                     MetersPerSecond(10).into(SpeedUnit(METER, SECOND)).toString())
        assertEquals("600 min⁻¹⋅m",
                     MetersPerSecond(10).into(SpeedUnit(METER, MINUTE)).toString())
        assertEquals("23622.04724409449 min⁻¹⋅in",
                     MetersPerSecond(10).into(SpeedUnit(INCH, MINUTE)).toString())
        assertEquals("393.7007874015748 s⁻¹⋅in",
                     MetersPerSecond(10).into(SpeedUnit(INCH, SECOND)).toString())
    }
}