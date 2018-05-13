package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.Seconds;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILLI;

public class CoulombsTest {
	private static final Coulombs coulombs = new Coulombs(50, MILLI);

	@Test
	public void dividedByTime() {
		assertEquals("0.002 A", coulombs.dividedBy(new Seconds(25), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals("25 s", coulombs.dividedBy(new Amperes(2, MILLI), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricCapacitance() {
		assertEquals("125 V", coulombs.dividedBy(new Farads(400, MICRO), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals("0.0004 F", coulombs.dividedBy(new Volts(125), DECIMAL64).toString());
	}

	@Test
	public void multipliedByElectricPotential() {
		assertEquals("5.000 J", coulombs.multipliedBy(new Volts(100), DECIMAL64).toString());
	}
}