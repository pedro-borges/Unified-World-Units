package pcb.uwu.amount.derived.optics;

import org.junit.Test;
import pcb.uwu.amount.base.Seconds;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class TalbotsTest {
	private static final Talbots talbots = new Talbots(50);

	@Test
	public void dividedByLuminousFlux() {
		assertEquals("10 s", talbots.dividedBy(new Lumens(5), DECIMAL64).toString());
	}

	@Test
	public void dividedByTime() {
		assertEquals("5 lm", talbots.dividedBy(new Seconds(10), DECIMAL64).toString());
	}
}