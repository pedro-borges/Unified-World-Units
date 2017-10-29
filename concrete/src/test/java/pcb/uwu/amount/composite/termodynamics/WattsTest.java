package pcb.uwu.amount.composite.termodynamics;

import org.junit.Test;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.Seconds;
import pcb.uwu.core.Magnitude;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class WattsTest {
	private static final Watts watts = new Watts(20);

	@Test
	public void multipliedByTime() {
		assertEquals(new Joules(300),
				watts.multipliedBy(new Seconds(15), DECIMAL64));
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals(new Volts(200),
				watts.dividedBy(new Amperes(100, Magnitude.MILLI), DECIMAL64));
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals(new Amperes(100, Magnitude.MILLI),
				watts.dividedBy(new Volts(200), DECIMAL64));
	}

}