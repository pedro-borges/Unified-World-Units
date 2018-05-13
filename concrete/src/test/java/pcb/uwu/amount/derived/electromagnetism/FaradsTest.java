package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MICRO;

public class FaradsTest {
	private static final Farads farads = new Farads(100, MICRO);

	@Test
	public void multipliedByElectricPotential() {
		assertEquals("0.002000 C", farads.multipliedBy(new Volts(20), DECIMAL64).toString());
	}

	@Test
	public void multipliedByElectricResistance() {
		assertEquals("0.200000 s", farads.multipliedBy(new Ohms(2, KILO), DECIMAL64).toString());
	}
}