package pcb.units.base;

import org.junit.Test;
import pcb.units.concrete.fundamental.imperial.InchUnit;
import pcb.units.concrete.fundamental.imperial.amounts.Inches;
import pcb.units.concrete.fundamental.si.MeterUnit;
import pcb.units.concrete.fundamental.si.amounts.Meters;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class AbstractUnitAmountTest {
	private static final AbstractUnitAmount<SpaceUnit> METER = new Meters(ONE);
	private static final AbstractUnitAmount<SpaceUnit> INCH = new Inches(ONE);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimal("0.0254"), METER.getAmountIn(new InchUnit()).getValue());
		assertEquals(new BigDecimal("0.0254").pow(-1, DECIMAL64), INCH.getAmountIn(new MeterUnit()).getValue());
	}
}