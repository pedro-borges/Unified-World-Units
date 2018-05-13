package pcb.uwu.amount.derived.optics;

import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;

public class LuxTest {
	private static final Lux lux = new Lux(2000);

	@Test
	public void multipliedByArea() {
		assertEquals(new Lumens(200),
				lux.multipliedBy(new SquareMeters(100, MILLI), DECIMAL64));
	}
}