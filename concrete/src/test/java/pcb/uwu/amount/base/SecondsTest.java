package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.thermodynamics.Watts;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SecondsTest {
	private static final Seconds seconds = new Seconds(7);

	@Test
	public void multipliedByElectricCurrent() {
		assertEquals("35 C", seconds.multipliedBy(new Amperes(5), DECIMAL64).toString());
	}

	@Test
	public void multipliedByPower() {
		assertEquals("35 J", seconds.multipliedBy(new Watts(5), DECIMAL64).toString());
	}

	@Test
	public void multipliedByLuminousFlux() {
		assertEquals("35 T", seconds.multipliedBy(new Lumens(5), DECIMAL64).toString());
	}
}