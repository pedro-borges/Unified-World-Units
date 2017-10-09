package pcb.uwu.amount.quantity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;

@RunWith(Parameterized.class)
public class LengthTest {
	@Parameters
	public static Object[] testData() {
		return new Object[] { meters,  };
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
		assertEquals(ONE, length.dividedBy(meters, DECIMAL64));
	}
}
