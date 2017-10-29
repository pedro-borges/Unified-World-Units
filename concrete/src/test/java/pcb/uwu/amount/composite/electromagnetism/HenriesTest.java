package pcb.uwu.amount.composite.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.quantity.Amperes;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class HenriesTest {
	private static final Henries henries = new Henries(5);

	@Test
	public void multipliedByElectricCurrent() {
		assertEquals(new Webbers(35, MILLI),
				henries.multipliedBy(new Amperes(7, MILLI), DECIMAL64));
	}
}