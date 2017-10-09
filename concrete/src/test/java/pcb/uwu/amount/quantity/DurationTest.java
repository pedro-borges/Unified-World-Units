package pcb.uwu.amount.quantity;

import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.quantity.HourUnit.HOUR;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class DurationTest {
	@Test
	public void testConstructFromDuration() {
		assertEquals("0.000000001s", new Time(Duration.ofNanos(1), SECOND).toString());
		assertEquals("0.001s", new Time(Duration.ofMillis(1), SECOND).toString());
		assertEquals("1s", new Time(Duration.ofSeconds(1), SECOND).toString());
		assertEquals("60s", new Time(Duration.ofMinutes(1), SECOND).toString());
		assertEquals("3600s", new Time(Duration.ofHours(1), SECOND).toString());
		assertEquals("86400s", new Time(Duration.ofDays(1), SECOND).toString());
		assertEquals("24h", new Time(Duration.ofDays(1), HOUR).toString());
	}
}