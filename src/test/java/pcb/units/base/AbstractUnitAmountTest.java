package pcb.units.base;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.concrete.fundamental.imperial.InchUnit;
import pcb.units.concrete.fundamental.imperial.Inches;
import pcb.units.concrete.fundamental.si.MeterUnit;
import pcb.units.concrete.fundamental.si.Meters;
import pcb.units.dimensions.fundamental.SpaceUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class AbstractUnitAmountTest {
	private static final BigDecimalAmount ONE = new BigDecimalAmount(1);
	private static final AbstractUnitAmount<BigDecimalAmount, SpaceUnit> METER = new Meters<>(ONE);
	private static final AbstractUnitAmount<BigDecimalAmount, SpaceUnit> INCH = new Inches<>(ONE);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimalAmount("0.0254"), INCH.getAmountIn(new MeterUnit()));
		assertEquals(new BigDecimalAmount("0.0254").pow(-1, DECIMAL64), METER.getAmountIn(new InchUnit()));
	}
}