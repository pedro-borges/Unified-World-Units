package pcb.units.dimensions.physics;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.composite.physics.Speed;
import pcb.units.composite.physics.SpeedUnit;
import pcb.units.concrete.space.InchUnit;
import pcb.units.concrete.space.Inches;
import pcb.units.concrete.space.MeterUnit;
import pcb.units.concrete.space.Meters;
import pcb.units.concrete.space.Miles;
import pcb.units.concrete.time.HourUnit;
import pcb.units.concrete.time.MinuteUnit;
import pcb.units.concrete.time.Minutes;
import pcb.units.concrete.time.SecondUnit;
import pcb.units.concrete.time.Seconds;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.time.Time;

import static java.math.BigDecimal.TEN;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;

public class SpeedTest {
	private final Space<BigDecimalAmount> space = new Meters<>(new BigDecimalAmount(10));
	private final Time time = new Minutes(2);
	private final Speed speed = Speed.create(DECIMAL64, space, time);

	@Test
	public void testCreateFromSpaceAndTime() {
		assertEquals(new BigDecimalAmount(5), speed.getAmount());
		assertEquals("m/min", speed.getUnit().getSymbol());
	}

	@Test
	public void testPlusSpeed() {
		Space<BigDecimalAmount> space = new Inches<>(new BigDecimalAmount(10));
		Time time = new Seconds(1);

		Speed speed = Speed.create(DECIMAL64, space, time);

		Speed result = this.speed.plus(speed, DECIMAL64);

		assertEquals(new BigDecimalAmount("20.24"), result.getAmount().withScale(2, HALF_EVEN));
		assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testMinusSpeed() {
		Space<BigDecimalAmount> space = new Inches<>(new BigDecimalAmount(10));
		Time time = new Seconds(1);

		Speed speed = Speed.create(DECIMAL64, space, time);

		Speed result = this.speed.minus(speed, DECIMAL64);

		assertEquals(new BigDecimalAmount("-10.24"), result.getAmount().withScale(2, HALF_EVEN));
		assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testMultipliedBy() {
		Speed result = speed.multipliedBy(TEN, DECIMAL64);

		assertEquals(new BigDecimalAmount("50"), result.getAmount().withScale(0, HALF_EVEN));
		assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testDividedBy() {
		Speed result = speed.dividedBy(TEN, DECIMAL64);

		assertEquals(new BigDecimalAmount("0.5"), result.getAmount().withScale(1, HALF_EVEN));
		assertEquals("m/min", result.getUnit().getSymbol());
	}

	@Test
	public void testConvertTo() {
		assertEquals(new BigDecimalAmount("0.0833"),
				speed.getAmountIn(new SpeedUnit(MeterUnit.instance, SecondUnit.instance)).withScale(4, HALF_EVEN));

		assertEquals(new BigDecimalAmount("196.85"),
				speed.getAmountIn(new SpeedUnit(InchUnit.instance, MinuteUnit.instance)).withScale(2, HALF_EVEN));

		assertEquals(new BigDecimalAmount("3.28"),
				speed.getAmountIn(new SpeedUnit(InchUnit.instance, SecondUnit.instance)).withScale(2, HALF_EVEN));
	}

	@Test
	public void testMitchGoesRunning() {
		Space<BigDecimalAmount> mitchDistance = new Meters<>(new BigDecimalAmount(1000));
		Time mitchTime = new Minutes(6);
		Speed mitchSpeed = Speed.create(DECIMAL64, mitchDistance, mitchTime);

		Space<BigDecimalAmount> wifeDistance = new Miles<>(new BigDecimalAmount(1));
		Time wifeTime = new Minutes(11);
		Speed wifeSpeed = Speed.create(DECIMAL64, wifeDistance, wifeTime);

		System.out.println("Mitch's speed: " + mitchSpeed.getAmountIn(new SpeedUnit(MeterUnit.instance, HourUnit.instance)));
		System.out.println("Wife's speed: " + wifeSpeed.getAmountIn(new SpeedUnit(MeterUnit.instance, HourUnit.instance)));
	}
}