package pcb.uwu.amount.derived.thermodynamics;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.core.Magnitude;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class WattsTest {
	private static final Watts watts = new Watts(20);

	@Test
	public void multipliedByTime() {
		assertEquals("300 J", watts.multipliedBy(new Seconds(15), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals("200 V", watts.dividedBy(new Amperes(100, Magnitude.MILLI), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals("0.1 A", watts.dividedBy(new Volts(200), DECIMAL64).toString());
	}

}