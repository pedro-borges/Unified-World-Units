package pcb.uwu.amount.quantity;

import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.quantity.HourUnit.HOUR;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class DurationTest {
	@Test
	public void testConstructFromDuration() {
		assertEquals("0.000000001 s", new Time(Duration.ofNanos(1), SECOND).toString());
		assertEquals("0.001 s", new Time(Duration.ofMillis(1), SECOND).toString());
		assertEquals("1 s", new Time(Duration.ofSeconds(1), SECOND).toString());
		assertEquals("60 s", new Time(Duration.ofMinutes(1), SECOND).toString());
		assertEquals("3600 s", new Time(Duration.ofHours(1), SECOND).toString());
		assertEquals("86400 s", new Time(Duration.ofDays(1), SECOND).toString());
		assertEquals("24 h", new Time(Duration.ofDays(1), HOUR).toString());
	}
}