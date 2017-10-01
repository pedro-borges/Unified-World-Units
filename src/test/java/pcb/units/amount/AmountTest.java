package pcb.units.amount;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;
import static pcb.units.amount.Magnitude.ALL_MAGNITUDES;
import static pcb.units.amount.Magnitude.MAJOR_MAGNITUDES;

public class AmountTest {
	@Test
	public void testConstructNumber() {
		Amount amount = new Amount(1);

		assertEquals("1", amount.toString());
	}

	@Test
	public void testConstructBigDecimal() {
		Amount amount = new Amount(ONE);

		assertEquals("1", amount.toString());
	}

	@Test
	public void withAutoMagnitudeHuge() {
		Amount amount = new Amount(new BigDecimal("1000000000000000000"));

		assertEquals("1000000T", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal1() {
		Amount amount = new Amount(123);

		assertEquals("1.23H", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeNormal2() {
		Amount amount = new Amount("123.4");

		assertEquals("123.4", amount.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void withAutoMagnitudeTiny() {
		Amount amount = new Amount(new BigDecimal("0.0000000000000000001"));

		assertEquals("0.0000001p", amount.toDecimalPrefixedString(ALL_MAGNITUDES));
	}

	@Test
	public void testPlusLowerMagnitude() {
		Amount amount1 = new Amount(1_000_000);
		Amount amount2 = new Amount(1_000);

		Amount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001M", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testPlusHigherMagnitude() {
		Amount amount1 = new Amount("0.000001");
		Amount amount2 = new Amount("0.001");

		Amount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001m", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeBig() {
		Amount amount1 = new Amount(1_000_000);
		Amount amount2 = new Amount(1_000);

		Amount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999K", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeBig() {
		Amount amount1 = new Amount(1_000);
		Amount amount2 = new Amount(1_000_000);

		Amount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999K", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusLowerMagnitudeSmall() {
		Amount amount1 = new Amount("0.001");
		Amount amount2 = new Amount("0.000001");

		Amount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999μ", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}

	@Test
	public void testMinusHigherMagnitudeSmall() {
		Amount amount1 = new Amount("0.000001");
		Amount amount2 = new Amount("0.001");

		Amount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999μ", sum.toDecimalPrefixedString(MAJOR_MAGNITUDES));
	}
}
