package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.derived.termodynamics.Joules;

import java.math.MathContext;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class VoltsTest {
	private static final Volts volts = new Volts(10);

	@Test
	public void divideByElectricResistance() {
		assertEquals(new Amperes(20, MILLI),
				volts.dividedBy(new Ohms(500), MathContext.DECIMAL64));
	}

	@Test
	public void divideByElectricCurrent() {
		assertEquals(new Ohms(500),
				volts.dividedBy(new Amperes(20, MILLI), MathContext.DECIMAL64));
	}

	@Test
	public void multiplyByElectricCharge() {
		assertEquals(new Joules(2),
				volts.multipliedBy(new Coulombs(200, MILLI), MathContext.DECIMAL64));
	}
}