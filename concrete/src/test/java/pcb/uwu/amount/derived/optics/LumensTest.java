package pcb.uwu.amount.derived.optics;

import org.junit.Test;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.scalar.Steradians;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class LumensTest {
	private static final Lumens lumens = new Lumens(22);

	@Test
	public void dividedBySolidAngle() {
		assertEquals("11 cd", lumens.dividedBy(new Steradians(2), DECIMAL64).toString());
	}

	@Test
	public void dividedByLuminousIntensity() {
		assertEquals("2 sr", lumens.dividedBy(new Candelas(11), DECIMAL64).toString());
	}

	@Test
	public void dividedByArea() {
		assertEquals("2 lx", lumens.dividedBy(new SquareMeters(11), DECIMAL64).toString());
	}

	@Test
	public void dividedByIlluminance() {
		assertEquals("11 m²", lumens.dividedBy(new Lux(2), DECIMAL64).toString());
	}

	@Test
	public void multipliedByTime() {
		assertEquals("66 T", lumens.multipliedBy(new Seconds(3), DECIMAL64).toString());
	}
}