package pcb.uwu.amount.derived.optics;

import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class NitsTest {
	private static final Nits nits = new Nits(4);

	@Test
	public void multipliedByArea() {
		assertEquals("20 cd", nits.multipliedBy(new SquareMeters(5), DECIMAL64).toString());
	}
}