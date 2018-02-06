package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Talbots;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.amount.derived.thermodynamics.Watts;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SecondsTest {
	private static final Seconds seconds = new Seconds(7);

	@Test
	public void multipliedByElectricCurrent() {
		assertEquals(new Coulombs(35),
				seconds.multipliedBy(new Amperes(5), DECIMAL64));
	}

	@Test
	public void multipliedByPower() {
		assertEquals(new Joules(35),
				seconds.multipliedBy(new Watts(5), DECIMAL64));
	}

	@Test
	public void multipliedByLuminousFlux() {
		assertEquals(new Talbots(35),
				seconds.multipliedBy(new Lumens(5), DECIMAL64));
	}
}