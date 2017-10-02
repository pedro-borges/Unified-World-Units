package pcb.units.amount;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;
import static pcb.units.amount.Magnitude.ALL_MAGNITUDES;
import static pcb.units.amount.Magnitude.MAJOR_MAGNITUDES;

public class BigDecimalAmountTest {
	@Test
	public void testConstructNumber() {
		BigDecimalAmount amount = new BigDecimalAmount(1);

		assertEquals("1", amount.toString());
	}

	@Test
	public void testConstructBigDecimal() {
		BigDecimalAmount amount = new BigDecimalAmount(ONE);

		assertEquals("1", amount.toString());
	}

	@Test
	public void withAutoMagnitudeHuge() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("1000000000000000000"));

		assertEquals("1000000T", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal1() {
		BigDecimalAmount amount = new BigDecimalAmount(123);

		assertEquals("1.23H", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal2() {
		BigDecimalAmount amount = new BigDecimalAmount("123.4");

		assertEquals("123.4", amount.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeTiny() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("0.0000000000000000001"));

		assertEquals("0.0000001p", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void testPlusLowerMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001M", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testPlusHigherMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001m", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999K", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999K", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.000001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999μ", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999μ", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}
}
