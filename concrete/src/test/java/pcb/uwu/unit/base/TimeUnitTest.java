package pcb.uwu.unit.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pcb.uwu.amount.base.Days;
import pcb.uwu.amount.base.Hours;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Minutes;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.base.Weeks;
import pcb.uwu.amount.derived.mechanics.Pace;
import pcb.uwu.amount.derived.mechanics.Speed;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;

import java.math.MathContext;

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

	@Test
	public void a()
	{
		Length distance = new Meters(10, Magnitude.KILO);
		Time duration = new Hours(2);
		Speed speed = distance.dividedBy(duration, MathContext.UNLIMITED);
		Pace pace = duration.dividedBy(distance, MathContext.UNLIMITED);

		System.out.println(speed.getAmount() + " " + speed.getUnit());
		System.out.println(pace.getAmount() + " " + pace.getUnit());
	}
}
