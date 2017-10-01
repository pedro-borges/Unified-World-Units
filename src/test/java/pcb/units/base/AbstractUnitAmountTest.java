package pcb.units.base;

import org.junit.Test;
import pcb.units.concrete.imperial.Inches;
import pcb.units.concrete.si.Meters;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.units.concrete.imperial.Inches.INCHES;
import static pcb.units.concrete.si.Meters.METERS;

public class AbstractUnitAmountTest {
	private static final AbstractUnitAmount<BigDecimal, SpaceUnit, Space> METER = new Meters(1);
	private static final AbstractUnitAmount<BigDecimal, SpaceUnit, Space> INCH = new Inches(1);

	@Test
	public void getValueIn() {
		assertEquals(new BigDecimal("0.0254"), METER.getValueIn(INCHES));
		assertEquals(new BigDecimal("0.0254").pow(-1, DECIMAL64), INCH.getValueIn(METERS));
	}
}