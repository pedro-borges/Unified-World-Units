package pcb.uwu.amount.derived.mechanics;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import static java.math.BigDecimal.TEN;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.HourUnit.HOUR;
import static pcb.uwu.unit.base.InchUnit.INCH;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.MileUnit.MILE;
import static pcb.uwu.unit.base.MinuteUnit.MINUTE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class SpeedTest {
	private final Length length = new Length(10, METER);
	private final Time time = new Time(2, MINUTE);
	private final Speed speed = length.dividedBy(time, DECIMAL64);

	@Test
	public void testPlusSpeed() {
		Length length = new Length(10, INCH);
		Time time = new Time(1, SECOND);

		Speed other = length.dividedBy(time, DECIMAL64);

		assertEquals("20.2400 min⁻¹⋅m", speed.plus(other, DECIMAL64).toString());
	}

	@Test
	public void testMinusSpeed() {
		Length length = new Length(10, INCH);
		Time time = new Time(1, SECOND);

		Speed other = length.dividedBy(time, DECIMAL64);

		assertEquals("-10.2400 min⁻¹⋅m", speed.minus(other, DECIMAL64).toString());
	}

	@Test
	public void testMultipliedBy() {
		assertEquals(new Speed(50, speed.getUnit()),
				speed.multipliedBy(TEN, DECIMAL64));
	}

	@Test
	public void testDividedBy() {
		assertEquals(new Speed("0.5", speed.getUnit()),
				speed.dividedBy(TEN, DECIMAL64));
	}

	@Test
	public void testDividedByTime() {
		assertEquals(new Acceleration("2.5", new AccelerationUnit(speed.getUnit(), time.getUnit())),
				speed.dividedBy(time, DECIMAL64));
	}

	@Test
	public void testMultipliedByTime() {
		assertEquals(new Length(10, METER),
				speed.multipliedBy(time, DECIMAL64));
	}

	@Test
	public void testConvertTo() {
		assertEquals(new BigDecimalAmount("0.0833"),
				speed.getAmountIn(new SpeedUnit(METER, SECOND)).withScale(4, HALF_EVEN));

		assertEquals(new BigDecimalAmount("196.85"),
				speed.getAmountIn(new SpeedUnit(INCH, MINUTE)).withScale(2, HALF_EVEN));

		assertEquals(new BigDecimalAmount("3.28"),
				speed.getAmountIn(new SpeedUnit(INCH, SECOND)).withScale(2, HALF_EVEN));
	}

	@Test
	public void testMitchGoesRunning() {
		Length mitchDistance = new Length(1000, METER);
		Time mitchTime = new Time(6, MINUTE);
		Speed mitchSpeed = mitchDistance.dividedBy(mitchTime, DECIMAL64);

		Length wifeDistance = new Length(1, MILE);
		Time wifeTime = new Time(11, MINUTE);
		Speed wifeSpeed = wifeDistance.dividedBy(wifeTime, DECIMAL64);

		SpeedUnit METERS_PER_HOUR = new SpeedUnit(METER, HOUR);

		System.out.println("Mitch's speed: " + mitchSpeed.convertTo(METERS_PER_HOUR));
		System.out.println("Wife's speed: " + wifeSpeed.convertTo(METERS_PER_HOUR));
	}
}