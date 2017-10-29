package pcb.uwu.amount.composite.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.Seconds;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILLI;

public class CoulombsTest {
	private static final Coulombs coulombs = new Coulombs(50, MILLI);

	@Test
	public void dividedByTime() {
		assertEquals(new Amperes(2, MILLI),
				coulombs.dividedBy(new Seconds(25), DECIMAL64));
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals(new Seconds(25),
				coulombs.dividedBy(new Amperes(2, MILLI), DECIMAL64));
	}

	@Test
	public void dividedByElectricCapacitance() {
		assertEquals(new Volts(125),
				coulombs.dividedBy(new Farads(400, MICRO), DECIMAL64));
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals(new Farads(400, MICRO),
				coulombs.dividedBy(new Volts(125), DECIMAL64));
	}

	@Test
	public void multipliedByElectricPotential() {
		assertEquals(new Joules(5),
				coulombs.multipliedBy(new Volts(100), DECIMAL64));
	}
}