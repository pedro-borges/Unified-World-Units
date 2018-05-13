package pcb.uwu.amount.derived.thermodynamics;

import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.mechanics.Newtons;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER;

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