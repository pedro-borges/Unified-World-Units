package pcb.uwu.amount.base;

import org.junit.Test;
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
		assertEquals("0.240 C", amperes.multipliedBy(new Minutes(2), DECIMAL64).toString());
	}

	@Test
	public void multipliedByElectricResistance() {
		assertEquals("4.000 V", amperes.multipliedBy(new Ohms(2, KILO), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricalPotential() {
		assertEquals("2 S", amperes.dividedBy(new Volts(1, MILLI), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricalConductance() {
		assertEquals("0.001 V", amperes.dividedBy(new Siemens(2), DECIMAL64).toString());
	}
}