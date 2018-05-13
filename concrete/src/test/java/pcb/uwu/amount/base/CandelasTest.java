package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.amount.derived.scalar.Steradians;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class CandelasTest {
	private static final Candelas candelas = new Candelas(18);

	@Test
	public void multipliedBySolidAngle() {
		assertEquals("54 lm", candelas.multipliedBy(new Steradians(3), DECIMAL64).toString());
	}

	@Test
	public void dividedByArea() {
		assertEquals("6 nit", candelas.dividedBy(new SquareMeters(3), DECIMAL64).toString());
	}

	@Test
	public void dividedByLuminance() {
		assertEquals("3 m²", candelas.dividedBy(new Nits(6), DECIMAL64).toString());
	}
}