package pcb.uwu.amount.derived.mechanics;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import static java.math.BigDecimal.TEN;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.InchUnit.INCH;
import static pcb.uwu.unit.base.MeterUnit.METER;
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
		assertEquals("50 min⁻¹⋅m", speed.multipliedBy(TEN, DECIMAL64).toString());
	}

	@Test
	public void testDividedBy() {
		assertEquals("0.5 min⁻¹⋅m", speed.dividedBy(TEN, DECIMAL64).toString());
	}

	@Test
	public void testDividedByTime() {
		assertEquals("2.5 min⁻²⋅m", speed.dividedBy(time, DECIMAL64).toString());
	}

	@Test
	public void testMultipliedByTime() {
		assertEquals("10 m", speed.multipliedBy(time, DECIMAL64).toString());
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
}