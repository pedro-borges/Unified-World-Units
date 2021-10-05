package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.derived.fundamental.Area;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;

public class WebbersTest {
	private static final Webbers webbers = new Webbers(12);

	@Test
	public void dividedByTime() {
		assertEquals("2 V", webbers.dividedBy(new Seconds(6), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals("6 s", webbers.dividedBy(new Volts(2), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals("2000 H", webbers.dividedBy(new Amperes(6, MILLI), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricInductance() {
		assertEquals("0.006 A", webbers.dividedBy(new Henries(2, KILO), DECIMAL64).toString());
	}

	@Test
	public void dividedByMagneticField() {
		assertEquals("2 m²", webbers.dividedBy(new Teslas(6), DECIMAL64).toString());
	}

	@Test
	public void dividedByArea() {
		assertEquals("6 T", webbers.dividedBy(new Area(2, SQUARE_METER), DECIMAL64).toString());
	}

	@Test
	public void multiplyByElectricCurrent() {
		assertEquals("0.600 J", webbers.multipliedBy(new Amperes(50, MILLI), DECIMAL64).toString());
	}

}