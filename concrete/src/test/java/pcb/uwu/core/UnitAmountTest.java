package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Yards;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class UnitAmountTest {
	private static final Length meters = new Meters(1);
	private static final Length yards = new Yards(4);
	private CompositeUnitAmount<? extends Unit> result;

	@Test
	public void testMajorMajor() {
		CompositeUnitAmount<? extends Unit> compositeUnit2 = yards.multipliedBy(yards, DECIMAL64);

		result = meters.multipliedBy(compositeUnit2, DECIMAL64);

		assertEquals("13.37803776 m³", result.toString());

		result = meters.dividedBy(compositeUnit2, DECIMAL64);

		assertEquals("0.06835083114610674 yd⁻¹", result.toString());
	}

	@Test
	public void testMajorMinor() {
		CompositeUnitAmount<? extends Unit> compositeUnit2 = yards.multipliedBy(yards, DECIMAL64).invert(DECIMAL64);

		result = meters.multipliedBy(compositeUnit2, DECIMAL64);

		assertEquals("0.06835083114610674 yd⁻¹", result.toString());
	}
}
