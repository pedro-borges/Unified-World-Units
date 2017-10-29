package pcb.uwu.amount.quantity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TimeTest {
	@Parameters
	public static Object[] testData() {
		return new Object[] { seconds, minutes, hours, days, weeks };
	}

	private static final Seconds seconds = new Seconds(604_800);
	private static final Minutes minutes = new Minutes(10_080);
	private static final Hours hours = new Hours(168);
	private static final Days days = new Days(7);
	private static final Weeks weeks = new Weeks(1);

	private Time time;

	public TimeTest(Time time) {
		this.time = time;
	}

	@Test
	public void testConversions() {
		assertEquals("1", time.dividedBy(seconds, DECIMAL64).toString());
		assertEquals("1", time.dividedBy(minutes, DECIMAL64).toString());
		assertEquals("1", time.dividedBy(hours, DECIMAL64).toString());
		assertEquals("1", time.dividedBy(days, DECIMAL64).toString());
		assertEquals("1", time.dividedBy(weeks, DECIMAL64).toString());
	}
}
