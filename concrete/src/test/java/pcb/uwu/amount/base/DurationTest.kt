package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.unit.base.HourUnit.HOUR
import pcb.uwu.unit.base.SecondUnit.SECOND
import java.time.Duration

class DurationTest
{
    @Test
    fun testConstructFromDuration()
    {
        assertEquals("0.000000001 s", Time(Duration.ofNanos(1), SECOND).toString())
        assertEquals("0.001 s", Time(Duration.ofMillis(1), SECOND).toString())
        assertEquals("1 s", Time(Duration.ofSeconds(1), SECOND).toString())
        assertEquals("60 s", Time(Duration.ofMinutes(1), SECOND).toString())
        assertEquals("3600 s", Time(Duration.ofHours(1), SECOND).toString())
        assertEquals("86400 s", Time(Duration.ofDays(1), SECOND).toString())
        assertEquals("24 h", Time(Duration.ofDays(1), HOUR).toString())
    }
}