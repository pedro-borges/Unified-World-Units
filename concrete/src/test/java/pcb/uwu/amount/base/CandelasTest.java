package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.area.SquareMeters;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.amount.derived.scalar.Steradians;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class CandelasTest {
	private static final Candelas candelas = new Candelas(18);

	@Test
	public void multipliedBySolidAngle() {
		assertEquals(new Lumens(54),
				candelas.multipliedBy(new Steradians(3), DECIMAL64));
	}

	@Test
	public void dividedByArea() {
		assertEquals(new Nits(6),
				candelas.dividedBy(new SquareMeters(3), DECIMAL64));
	}

	@Test
	public void dividedByLuminance() {
		assertEquals(new SquareMeters(3),
				candelas.dividedBy(new Nits(6), DECIMAL64));
	}
}