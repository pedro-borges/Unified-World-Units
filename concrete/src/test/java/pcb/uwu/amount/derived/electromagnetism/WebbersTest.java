package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.termodynamics.Joules;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;

public class WebbersTest {
	private static final Webbers webbers = new Webbers(12);

	@Test
	public void dividedByTime() {
		assertEquals(new Volts(2),
				webbers.dividedBy(new Seconds(6), DECIMAL64));
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals(new Seconds(6),
				webbers.dividedBy(new Volts(2), DECIMAL64));
	}

	@Test
	public void dividedByElectricCurrent() {
		assertEquals(new Henries(2, KILO),
				webbers.dividedBy(new Amperes(6, MILLI), DECIMAL64));
	}

	@Test
	public void dividedByElectricInductance() {
		assertEquals(new Amperes(6, MILLI),
				webbers.dividedBy(new Henries(2, KILO), DECIMAL64));
	}

	@Test
	public void dividedByMagneticField() {
		assertEquals(new Area(2, SQUARE_METER),
				webbers.dividedBy(new Teslas(6), DECIMAL64));
	}

	@Test
	public void dividedByArea() {
		assertEquals(new Teslas(6),
				webbers.dividedBy(new Area(2, SQUARE_METER), DECIMAL64));
	}

	@Test
	public void multiplyByElectricCurrent() {
		assertEquals(new Joules(600, MILLI),
				webbers.multipliedBy(new Amperes(50, MILLI), DECIMAL64));
	}

}