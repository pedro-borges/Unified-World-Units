package pcb.uwu.amount.derived.optics;

import org.junit.Test;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.scalar.Steradians;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class LumensTest {
	private static final Lumens lumens = new Lumens(22);

	@Test
	public void dividedBySolidAngle() {
		assertEquals(new Candelas(11),
				lumens.dividedBy(new Steradians(2), DECIMAL64));
	}

	@Test
	public void dividedByLuminousIntensity() {
		assertEquals(new Steradians(2),
				lumens.dividedBy(new Candelas(11), DECIMAL64));
	}
}