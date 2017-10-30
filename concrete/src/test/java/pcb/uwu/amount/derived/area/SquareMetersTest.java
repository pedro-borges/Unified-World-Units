package pcb.uwu.amount.derived.area;

import org.junit.Test;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.core.Magnitude;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SquareMetersTest {
	private static final SquareMeters squareMeters = new SquareMeters(500, Magnitude.MILLI);

	@Test
	public void multipliedByLuminance() {
		assertEquals(new Candelas(2),
				squareMeters.multipliedBy(new Nits(4), DECIMAL64));
	}
}