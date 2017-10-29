package pcb.uwu.amount.composite.termodynamics;

import org.junit.Test;
import pcb.uwu.amount.composite.fundamental.Area;
import pcb.uwu.amount.composite.fundamental.Volume;
import pcb.uwu.amount.composite.mechanics.Newtons;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.fundamental.CubicMeterUnit.CUBIC_METER;
import static pcb.uwu.unit.composite.fundamental.SquareMeterUnit.SQUARE_METER;

public class PascalsTest {
	private static final Pascals pascals = new Pascals(9);

	@Test
	public void multipliedByVolume() {
		assertEquals(new Joules(27),
				pascals.multipliedBy(new Volume(3, CUBIC_METER), DECIMAL64));
	}

	@Test
	public void multipliedByArea() {
		assertEquals(new Newtons(18),
				pascals.multipliedBy(new Area(2, SQUARE_METER), DECIMAL64));
	}
}