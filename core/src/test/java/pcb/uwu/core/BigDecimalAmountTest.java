package pcb.uwu.core;

import org.junit.Test;

import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

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
	public void testPlusBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1001000", sum.toString());
	}

	@Test
	public void testPlusSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("0.001001", sum.toString());
	}

	@Test
	public void testMinusSmallerBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("999000", sum.toString());
	}

	@Test
	public void testMinusHigherBig() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1_000);
		BigDecimalAmount amount2 = new BigDecimalAmount(1_000_000);

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999000", sum.toString());
	}

	@Test
	public void testMinusLowerSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.000001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("0.000999", sum.toString());
	}

	@Test
	public void testMinusHigherSmall() {
		BigDecimalAmount amount1 = new BigDecimalAmount("0.000001");
		BigDecimalAmount amount2 = new BigDecimalAmount("0.001");

		BigDecimalAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-0.000999", sum.toString());
	}
}
