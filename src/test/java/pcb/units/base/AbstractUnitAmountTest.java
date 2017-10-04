package pcb.units.base;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.concrete.space.InchUnit;
import pcb.units.concrete.space.Inches;
import pcb.units.concrete.space.MeterUnit;
import pcb.units.concrete.space.Meters;
import pcb.units.dimensions.space.SpaceUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class AbstractUnitAmountTest {
	private static final AbstractUnitAmount<BigDecimalAmount, SpaceUnit> METER = new Meters(1);
	private static final AbstractUnitAmount<BigDecimalAmount, SpaceUnit> INCH = new Inches(1);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimalAmount("0.0254"), INCH.getAmountIn(MeterUnit.instance));
		assertEquals(new BigDecimalAmount("0.0254").pow(-1, DECIMAL64), METER.getAmountIn(InchUnit.instance));
	}
}