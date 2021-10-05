package pcb.uwu.amount.derived.area;

import org.junit.Test;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.optics.Lux;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.core.Magnitude;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.DEKA;

public class SquareMetersTest {
	private static final SquareMeters squareMeters = new SquareMeters(500, Magnitude.MILLI);

	@Test
	public void circleFactory() {
		SquareMeters circle;

		circle = SquareMeters.FOR.circleWithRadius(new Meters(1, DECI), DECIMAL64);
		assertEquals("0.03141592653589793 m²", circle.toString());

		circle = SquareMeters.FOR.circleWithRadius(new Meters(1), DECIMAL64);
		assertEquals("3.141592653589793 m²", circle.toString());

		circle = SquareMeters.FOR.circleWithRadius(new Meters(1, DEKA), DECIMAL64);
		assertEquals("314.1592653589793 m²", circle.toString());
	}

	@Test
	public void squareFactory() {
		SquareMeters square;

		square = SquareMeters.FOR.squareWithSide(new Meters(1, DECI), DECIMAL64);
		assertEquals("0.01 m²", square.toString());

		square = SquareMeters.FOR.squareWithSide(new Meters(1), DECIMAL64);
		assertEquals("1 m²", square.toString());

		square = SquareMeters.FOR.squareWithSide(new Meters(1, DEKA), DECIMAL64);
		assertEquals("100 m²", square.toString());
	}

	@Test
	public void multipliedByLuminance() {
		assertEquals("2.000 cd", squareMeters.multipliedBy(new Nits(4), DECIMAL64).toString());
	}

	@Test
	public void multipliedByIlluminance() {
		assertEquals("2.000 lm", squareMeters.multipliedBy(new Lux(4), DECIMAL64).toString());
	}
}