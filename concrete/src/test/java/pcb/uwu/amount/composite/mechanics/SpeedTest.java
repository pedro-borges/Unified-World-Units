package pcb.uwu.amount.composite.mechanics;

import org.junit.Assert;
import org.junit.Test;
import pcb.uwu.amount.quantity.Length;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.units.composite.mechanics.SpeedUnit;

import static java.math.BigDecimal.TEN;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.quantity.HourUnit.HOUR;
import static pcb.uwu.unit.quantity.InchUnit.INCH;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.MileUnit.MILE;
import static pcb.uwu.unit.quantity.MinuteUnit.MINUTE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class SpeedTest {
	private final Length length = new Length(10, METER);
	private final Time time = new Time(2, MINUTE);
	private final Speed speed = length.dividedBy(time, DECIMAL64);

	@Test
	public void testCreateFromSpaceAndTime() {
		assertEquals(new BigDecimalAmount(5), speed.getAmount());
		Assert.assertEquals("m/min", speed.getUnit().getSymbol());
	}

	@Test
	public void testPlusSpeed() {
		Length length = new Length(10, INCH);
		Time time = new Time(1, SECOND);

		Speed other = length.dividedBy(time, DECIMAL64);

		Speed result = speed.plus(other, DECIMAL64);

		assertEquals(new BigDecimalAmount("20.24"), result.getAmount().withScale(2, HALF_EVEN));
		Assert.assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testMinusSpeed() {
		Length length = new Length(10, INCH);
		Time time = new Time(1, SECOND);

		Speed other = length.dividedBy(time, DECIMAL64);

		Speed result = speed.minus(other, DECIMAL64);

		assertEquals(new BigDecimalAmount("-10.24"), result.getAmount().withScale(2, HALF_EVEN));
		Assert.assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testMultipliedBy() {
		Speed result = speed.multipliedBy(TEN, DECIMAL64);

		assertEquals(new BigDecimalAmount("50"), result.getAmount().withScale(0, HALF_EVEN));
		Assert.assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testDividedBy() {
		Speed result = speed.dividedBy(TEN, DECIMAL64);

		assertEquals(new BigDecimalAmount("0.5"), result.getAmount().withScale(1, HALF_EVEN));
		Assert.assertEquals("m/min", result.getUnit().getSymbol());
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