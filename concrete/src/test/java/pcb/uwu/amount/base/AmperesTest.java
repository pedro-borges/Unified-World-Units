package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.electromagnetism.Ohms;
import pcb.uwu.amount.derived.electromagnetism.Siemens;
import pcb.uwu.amount.derived.electromagnetism.Volts;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MILLI;

public class AmperesTest {
	private static final Amperes amperes = new Amperes(2, MILLI);

	@Test
	public void multipliedByTime() {
		assertEquals(new Coulombs(240, MILLI),
				amperes.multipliedBy(new Minutes(2), DECIMAL64));
	}

	@Test
	public void multipliedByElectricResistance() {
		assertEquals(new Volts("4.000"),
				amperes.multipliedBy(new Ohms(2, KILO), DECIMAL64));
	}

	@Test
	public void dividedByElectricalPotential() {
		assertEquals(new Siemens(2),
				amperes.dividedBy(new Volts(1, MILLI), DECIMAL64));
	}

	@Test
	public void dividedByElectricalConductance() {
		assertEquals(new Volts(1, MILLI),
				amperes.dividedBy(new Siemens(2), DECIMAL64));
	}
}