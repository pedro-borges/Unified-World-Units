package pcb.uwu.amount.derived.scalar;

import org.junit.Test;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.optics.Lumens;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SteradiansTest {
	private static final Steradians steradians = new Steradians(13);

	@Test
	public void multipliedByLuminousIntensity() {
		assertEquals(new Lumens(39),
				steradians.multipliedBy(new Candelas(3), DECIMAL64));
	}
}