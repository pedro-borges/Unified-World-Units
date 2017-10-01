package pcb.units.base;

import org.junit.Test;
import pcb.units.concrete.imperial.InchUnit;
import pcb.units.concrete.imperial.amounts.Inches;
import pcb.units.concrete.si.MeterUnit;
import pcb.units.concrete.si.amounts.Meters;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class AbstractUnitAmountTest {
	private static final AbstractUnitAmount<BigDecimal, SpaceUnit<BigDecimal>> METER = new Meters<>(ONE);
	private static final AbstractUnitAmount<BigDecimal, SpaceUnit<BigDecimal>> INCH = new Inches<>(ONE);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimal("0.0254"), METER.getAmountIn(new InchUnit<>()).getValue());
		assertEquals(new BigDecimal("0.0254").pow(-1, DECIMAL64), INCH.getAmountIn(new MeterUnit<>()).getValue());
	}
}