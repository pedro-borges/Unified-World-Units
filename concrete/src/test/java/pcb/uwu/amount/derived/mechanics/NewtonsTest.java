package pcb.uwu.amount.derived.mechanics;

import org.junit.Test;
import pcb.uwu.amount.base.KiloGrams;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.termodynamics.Joules;
import pcb.uwu.amount.derived.termodynamics.Pascals;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;

public class NewtonsTest {
	private static final Newtons newtons = new Newtons(12);

	@Test
	public void dividedByAcceleration() {
		assertEquals(new KiloGrams(4),
				newtons.dividedBy(new Acceleration(3, new AccelerationUnit(METER, SECOND)), DECIMAL64));
	}

	@Test
	public void dividedByMass() {
		assertEquals(new Acceleration(3, new AccelerationUnit(METER, SECOND)),
				newtons.dividedBy(new KiloGrams(4), DECIMAL64));
	}

	@Test
	public void multipliedByLength() {
		assertEquals(new Joules(60),
				newtons.multipliedBy(new Meters(5), DECIMAL64));
	}

	@Test
	public void dividedByPressure() {
		assertEquals(new Area(4, SQUARE_METER),
				newtons.dividedBy(new Pascals(3), DECIMAL64));
	}

	@Test
	public void dividedByArea() {
		assertEquals(new Pascals(3),
				newtons.dividedBy(new Area(4, SQUARE_METER), DECIMAL64));
	}
}