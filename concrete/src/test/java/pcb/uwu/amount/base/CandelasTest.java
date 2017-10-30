package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.scalar.Steradians;

import java.math.MathContext;

import static org.junit.Assert.assertEquals;

public class CandelasTest {
	private static final Candelas candelas = new Candelas(18);

	@Test
	public void multipliedBySolidAngle() {
		assertEquals(new Lumens(54),
				candelas.multipliedBy(new Steradians(3), MathContext.DECIMAL64));
	}
}