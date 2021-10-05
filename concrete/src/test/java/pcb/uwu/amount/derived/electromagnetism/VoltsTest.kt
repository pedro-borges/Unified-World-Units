package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;

import java.math.MathContext;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class VoltsTest {
	private static final Volts volts = new Volts(10);

	@Test
	public void divideByElectricResistance() {
		assertEquals("0.02 A", volts.dividedBy(new Ohms(500), MathContext.DECIMAL64).toString());
	}

	@Test
	public void divideByElectricCurrent() {
		assertEquals("500 Ω", volts.dividedBy(new Amperes(20, MILLI), MathContext.DECIMAL64).toString());
	}

	@Test
	public void multiplyByElectricCharge() {
		assertEquals("2.000 J",
				volts.multipliedBy(new Coulombs(200, MILLI), MathContext.DECIMAL64).toString());
	}
}