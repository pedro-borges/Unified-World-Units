package pcb.units.amount;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;
import static pcb.units.amount.Magnitude.NATURAL;
import static pcb.units.amount.Magnitude.DECA;
import static pcb.units.amount.Magnitude.DECI;
import static pcb.units.amount.Magnitude.KILO;
import static pcb.units.amount.Magnitude.MEGA;
import static pcb.units.amount.Magnitude.MICRO;
import static pcb.units.amount.Magnitude.MILI;

public class BigDecimalAmountTest {
	@Test
	public void testConstructNumber() {
		BigDecimalAmount amount = new BigDecimalAmount(1);

		assertEquals("1", amount.toString());
		assertEquals(0, amount.getScale());
		assertEquals(NATURAL, amount.getMagnitude());
	}

	@Test
	public void testConstructBigDecimal() {
		BigDecimalAmount amount = new BigDecimalAmount(ONE);

		assertEquals("1", amount.toString());
		assertEquals(0, amount.getScale());
		assertEquals(NATURAL, amount.getMagnitude());
	}

	@Test
	public void testConstructNumberMagnitude() {
		BigDecimalAmount amount = new BigDecimalAmount(1, KILO);

		assertEquals("1K", amount.toString());
		assertEquals(0, amount.getScale());
		assertEquals(KILO, amount.getMagnitude());
	}

	@Test
	public void testConstructBigDecimalMagnitude() {
		BigDecimalAmount amount = new BigDecimalAmount(ONE, KILO);

		assertEquals("1K", amount.toString());
	}

	@Test
	public void testWithLowerMagnitude() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("0.1"), DECA).withMagnitude(DECI);

		assertEquals("10d", amount.toString());
	}

	@Test
	public void testWithHigherMagnitude() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("10"), DECI).withMagnitude(DECA);

		assertEquals("0.1D", amount.toString());
	}

	@Test
	public void withAutoMagnitudeHuge() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("1000000000000000000"));

		assertEquals("1000000T", amount.withAutoMagnitude().toString());
	}

	@Test
	public void withAutoMagnitudeNormal() {
		BigDecimalAmount amount = new BigDecimalAmount(123);

		assertEquals("1.23H", amount.withAutoMagnitude().toString());
	}

	@Test
	public void withAutoMagnitudeTiny() {
		BigDecimalAmount amount = new BigDecimalAmount(new BigDecimal("0.0000000000000000001"));

		assertEquals("0.0000001p", amount.withAutoMagnitude().toString());
	}

	@Test
	public void testPlusLowerMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1, MEGA);
		BigDecimalAmount amount2 = new BigDecimalAmount(1, KILO);

		Amount<BigDecimal> sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1.001M", sum.toString());
	}

	@Test
	public void testPlusHigherMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1, MICRO);
		BigDecimalAmount amount2 = new BigDecimalAmount(1, MILI);

		Amount<BigDecimal> sum = amount1.plus(amount2, UNLIMITED);

		assertEquals("1001μ", sum.toString());
	}

	@Test
	public void testMinusLowerMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1, MEGA);
		BigDecimalAmount amount2 = new BigDecimalAmount(1, KILO);

		Amount<BigDecimal> sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("0.999M", sum.toString());
	}

	@Test
	public void testMinusHigherMagnitude() {
		BigDecimalAmount amount1 = new BigDecimalAmount(1, MICRO);
		BigDecimalAmount amount2 = new BigDecimalAmount(1, MILI);

		Amount<BigDecimal> sum = amount1.minus(amount2, UNLIMITED);

		assertEquals("-999μ", sum.toString());
	}
}
