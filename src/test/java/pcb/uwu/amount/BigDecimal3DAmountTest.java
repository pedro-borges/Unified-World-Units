package pcb.uwu.amount;

import org.junit.Test;
import pcb.uwu.core.BigDecimal3DAmount;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class BigDecimal3DAmountTest {
	@Test
	public void testConstructNumber() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(1, 2, 3);

		assertEquals("[1, 2, 3]", amount.toString());
	}

	@Test
	public void testConstructBigDecimal() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(ONE, TEN, ZERO);

		assertEquals("[1, 10, 0]", amount.toString());
	}

	@Test
	public void testPlus() {
		BigDecimal3DAmount amount1 = new BigDecimal3DAmount(10, 20, 30);
		BigDecimal3DAmount amount2 = new BigDecimal3DAmount(1, 2, 3);

		BigDecimal3DAmount sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("[11, 22, 33]", sum.toString());
	}

	@Test
	public void testMinusSmaller() {
		BigDecimal3DAmount amount1 = new BigDecimal3DAmount(10, 20, 30);
		BigDecimal3DAmount amount2 = new BigDecimal3DAmount(1, 2, 3);

		BigDecimal3DAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("[9, 18, 27]", sum.toString());
	}

	@Test
	public void testMinusBigger() {
		BigDecimal3DAmount amount1 = new BigDecimal3DAmount(1, 2, 3);
		BigDecimal3DAmount amount2 = new BigDecimal3DAmount(10, 20, 30);

		BigDecimal3DAmount sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("[-9, -18, -27]", sum.toString());
	}

	@Test
	public void testMultipliedByPositive() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(-1, -2, -3);

		BigDecimal3DAmount sum = amount.multipliedBy(TEN, UNLIMITED);

		assertEquals("[-10, -20, -30]", sum.toString());
	}

	@Test
	public void testMultipliedByNegative() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(-1, -2, -3);

		BigDecimal3DAmount sum = amount.multipliedBy(TEN.negate(), UNLIMITED);

		assertEquals("[10, 20, 30]", sum.toString());
	}

	@Test
	public void testDividedByPositive() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(-1, -2, -3);

		BigDecimal3DAmount sum = amount.dividedBy(TEN, UNLIMITED);

		assertEquals("[-0.1, -0.2, -0.3]", sum.toString());
	}

	@Test
	public void testDividedByNegative() {
		BigDecimal3DAmount amount = new BigDecimal3DAmount(-1, -2, -3);

		BigDecimal3DAmount sum = amount.dividedBy(TEN.negate(), UNLIMITED);

		assertEquals("[0.1, 0.2, 0.3]", sum.toString());
	}
}
