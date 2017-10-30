package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Seconds;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILLI;

public class FaradsTest {
	private static final Farads farads = new Farads(100, MICRO);

	@Test
	public void multipliedByElectricPotential() {
		assertEquals(new Coulombs(2, MILLI),
				farads.multipliedBy(new Volts(20), DECIMAL64));
	}

	@Test
	public void multipliedByElectricResistance() {
		assertEquals(new Seconds(2, DECI),
				farads.multipliedBy(new Ohms(2, KILO), DECIMAL64));
	}
}