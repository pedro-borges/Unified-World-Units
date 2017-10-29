package pcb.uwu.amount.composite.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.quantity.Amperes;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class OhmsTest {
	private static final Ohms ohms = new Ohms(1500);

	@Test
	public void multipliedByElectricCurrent() {
		assertEquals(new Volts(75),
				ohms.multipliedBy(new Amperes(50, MILLI), DECIMAL64));
	}
}