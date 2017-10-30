package pcb.uwu.unit.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pcb.uwu.amount.base.Feet;
import pcb.uwu.amount.base.Inches;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Miles;
import pcb.uwu.amount.base.Yards;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.LengthUnit;

import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;

@RunWith(Parameterized.class)
public class LengthUnitTest {
	@Parameters
	@SuppressWarnings("unchecked")
	public static UnitAmount<LengthUnit>[] testData() {
		return new UnitAmount[] { miles, yards, meters, feet, inches };
	}

	private static final Miles miles = new Miles(1);
	private static final Yards yards = new Yards(1760);
	private static final Meters meters = new Meters("1609.344");
	private static final Feet feet = new Feet(5280);
	private static final Inches inches = new Inches(63360);

	private Length length;

	public LengthUnitTest(Length length) {
		this.length = length;
	}

	@Test
	public void testConversions() {
		BigDecimalAmount one = ONE.withScale(6, HALF_EVEN);

		for (UnitAmount<LengthUnit> unitAmount : testData()) {
			assertEquals(one, length.dividedBy(unitAmount, DECIMAL64).getAmount().withScale(6, HALF_EVEN));
		}
	}
}
