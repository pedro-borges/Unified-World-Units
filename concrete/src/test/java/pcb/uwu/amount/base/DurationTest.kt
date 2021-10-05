package pcb.uwu.amount.base

import pcb.uwu.unit.base.HourUnit
import pcb.uwu.unit.base.SecondUnit
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertEquals

class DurationTest
{
    @Test
    fun testConstructFromDuration()
    {
        assertEquals(expected = "0.000000001 s",
                     actual = Time(Duration.ofNanos(1), SecondUnit).toString())
        assertEquals(expected = "0.001 s",
                     actual = Time(Duration.ofMillis(1), SecondUnit).toString())
        assertEquals(expected = "1 s",
                     actual = Time(Duration.ofSeconds(1), SecondUnit).toString())
        assertEquals(expected = "60 s",
                     actual = Time(Duration.ofMinutes(1), SecondUnit).toString())
        assertEquals(expected = "3600 s",
                     actual = Time(Duration.ofHours(1), SecondUnit).toString())
        assertEquals(expected = "86400 s",
                     actual = Time(Duration.ofDays(1), SecondUnit).toString())
        assertEquals(expected = "24 h",
                     actual = Time(Duration.ofDays(1), HourUnit).toString())
    }
}