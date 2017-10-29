package pcb.uwu.amount.quantity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pcb.uwu.core.BigDecimalAmount;

import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;

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
		BigDecimalAmount one = ONE.withScale(6, HALF_EVEN);

		assertEquals(one, time.dividedBy(seconds, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, time.dividedBy(minutes, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, time.dividedBy(hours, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, time.dividedBy(days, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, time.dividedBy(weeks, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
	}
}
