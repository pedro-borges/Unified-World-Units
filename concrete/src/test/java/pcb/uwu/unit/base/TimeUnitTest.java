package pcb.uwu.unit.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pcb.uwu.amount.base.Days;
import pcb.uwu.amount.base.Hours;
import pcb.uwu.amount.base.Minutes;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.base.Weeks;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.TimeUnit;

import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;

@RunWith(Parameterized.class)
public class TimeUnitTest {
	@Parameters
	@SuppressWarnings("unchecked")
	public static UnitAmount<TimeUnit>[] testData() {
		return new UnitAmount[] { seconds, minutes, hours, days, weeks };
	}

	private static final Seconds seconds = new Seconds(604_800);
	private static final Minutes minutes = new Minutes(10_080);
	private static final Hours hours = new Hours(168);
	private static final Days days = new Days(7);
	private static final Weeks weeks = new Weeks(1);

	private Time time;

	public TimeUnitTest(Time time) {
		this.time = time;
	}

	@Test
	public void testConversions() {
		BigDecimalAmount one = ONE.withScale(6, HALF_EVEN);

		for (UnitAmount<TimeUnit> unitAmount : testData()) {
			assertEquals(one, time.dividedBy(unitAmount, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		}
	}
}
