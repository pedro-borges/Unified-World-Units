package pcb.uwu.core;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.ALL_MAGNITUDES;
import static pcb.uwu.core.Magnitude.MAJOR_MAGNITUDES;

public class BigDecimalAmountTest {
	@Test
	public void testConstructNumber() {
		BigDecimalAmount amount = new BigDecimalAmount(1);

		assertEquals("1", amount.toString());
	}

	@Test
	public void testConstructBigDecimal() {
		BigDecimalAmount amount = new BigDecimalAmount(1);

		assertEquals("1", amount.toString());
	}

	@Test
	public void withAutoMagnitudeHuge() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("1000000000000000000"));

		assertEquals("1000000T", amount.toStringWithMagnitude(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal1() {
		BigDecimalAmount amount = new BigDecimalAmount(123);

		assertEquals("1.23H", amount.toStringWithMagnitude(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal2() {
		BigDecimalAmount amount = new BigDecimalAmount("123.4");

		assertEquals("123.4", amount.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeTiny() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("0.0000000000000000001"));

		assertEquals("0.0000001p", amount.toStringWithMagnitude(ALL_MAGNITUDES));
	}

	@Test
	public void testPlusLowerMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001M", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testPlusHigherMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001m", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999K", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999K", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.000001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999μ", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999μ", sum.toStringWithMagnitude(MAJOR_MAGNITUDES));
	}

	@Test
	public void testStringWithMagnitudes() {
//		assertEquals("1T", new BigDecimalAmount("1000000000000").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1G", new BigDecimalAmount("1000000000").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1M", new BigDecimalAmount("1000000").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1K", new BigDecimalAmount("1000").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1H", new BigDecimalAmount("100").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1D", new BigDecimalAmount("10").toStringWithMagnitude(ALL_MAGNITUDES));
//		assertEquals("1", new BigDecimalAmount("1").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1d", new BigDecimalAmount("0.1").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1c", new BigDecimalAmount("0.01").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1m", new BigDecimalAmount("0.001").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1μ", new BigDecimalAmount("0.000001").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1n", new BigDecimalAmount("0.000000001").toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1p", new BigDecimalAmount("0.000000000001").toStringWithMagnitude(ALL_MAGNITUDES));
	}
}
