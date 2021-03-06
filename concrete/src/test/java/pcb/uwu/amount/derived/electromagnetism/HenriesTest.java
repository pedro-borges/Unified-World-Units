package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class HenriesTest {
	private static final Henries henries = new Henries(5);

	@Test
	public void multipliedByElectricCurrent() {
		assertEquals("0.035 Wb", henries.multipliedBy(new Amperes(7, MILLI), DECIMAL64).toString());
	}
}