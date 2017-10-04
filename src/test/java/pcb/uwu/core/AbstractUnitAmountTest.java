package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.units.fundamental.LengthUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.fundamental.LengthUnit.INCH;
import static pcb.uwu.units.fundamental.LengthUnit.METER;

public class AbstractUnitAmountTest {
	private static final AbstractUnitAmount<BigDecimalAmount, LengthUnit> METERS = new Length(1, METER);
	private static final AbstractUnitAmount<BigDecimalAmount, LengthUnit> INCHES = new Length(1, INCH);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimalAmount("0.0254"), INCHES.getAmountIn(METER));
		assertEquals(new BigDecimalAmount("0.0254").pow(-1, DECIMAL64), METERS.getAmountIn(INCH));
	}
}