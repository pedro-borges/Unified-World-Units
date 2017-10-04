package pcb.uwu.core;

import org.junit.Test;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class BigDecimal2DAmountTest {
	@Test
	public void testConstructNumber() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(1, 2);

		assertEquals("[1, 2]", amount.toString());
	}

	@Test
	public void testConstructBigDecimal() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(ONE, TEN);

		assertEquals("[1, 10]", amount.toString());
	}

	@Test
	public void testPlus() {
		BigDecimal2DAmount amount1 = new BigDecimal2DAmount(10, 20);
		BigDecimal2DAmount amount2 = new BigDecimal2DAmount(1, 2);

		BigDecimal2DAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("[11, 22]", sum.toString());
	}

	@Test
	public void testMinusSmaller() {
		BigDecimal2DAmount amount1 = new BigDecimal2DAmount(10, 20);
		BigDecimal2DAmount amount2 = new BigDecimal2DAmount(1, 2);

		BigDecimal2DAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("[9, 18]", sum.toString());
	}

	@Test
	public void testMinusBigger() {
		BigDecimal2DAmount amount1 = new BigDecimal2DAmount(1, 2);
		BigDecimal2DAmount amount2 = new BigDecimal2DAmount(10, 20);

		BigDecimal2DAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("[-9, -18]", sum.toString());
	}

	@Test
	public void testMultipliedByPositive() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(-1, -2);

		BigDecimal2DAmount sum = amount.multipliedBy(TEN, UNLIMITED);

		assertEquals("[-10, -20]", sum.toString());
	}

	@Test
	public void testMultipliedByNegative() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(-1, -2);

		BigDecimal2DAmount sum = amount.multipliedBy(TEN.negate(), UNLIMITED);

		assertEquals("[10, 20]", sum.toString());
	}

	@Test
	public void testDividedByPositive() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(-1, -2);

		BigDecimal2DAmount sum = amount.dividedBy(TEN, UNLIMITED);

		assertEquals("[-0.1, -0.2]", sum.toString());
	}

	@Test
	public void testDividedByNegative() {
		BigDecimal2DAmount amount = new BigDecimal2DAmount(-1, -2);

		BigDecimal2DAmount sum = amount.dividedBy(TEN.negate(), UNLIMITED);

		assertEquals("[0.1, 0.2]", sum.toString());
	}
}
