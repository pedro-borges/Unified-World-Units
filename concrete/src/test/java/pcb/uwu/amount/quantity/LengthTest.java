package pcb.uwu.amount.quantity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pcb.uwu.core.BigDecimalAmount;

import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;

@RunWith(Parameterized.class)
public class LengthTest {
	@Parameters
	public static Object[] testData() {
		return new Object[] { miles, yards, meters, feet, inches };
	}

	private static final Miles miles = new Miles(1);
	private static final Yards yards = new Yards(1760);
	private static final Meters meters = new Meters("1609.344");
	private static final Feet feet = new Feet(5280);
	private static final Inches inches = new Inches(63360);

	private Length length;

	public LengthTest(Length length) {
		this.length = length;
	}

	@Test
	public void testConversions() {
		BigDecimalAmount one = ONE.withScale(6, HALF_EVEN);

		assertEquals(one, length.dividedBy(miles, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, length.dividedBy(yards, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, length.dividedBy(meters, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, length.dividedBy(feet, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		assertEquals(one, length.dividedBy(inches, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
	}
}
