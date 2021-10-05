package pcb.uwu.amount.derived.mechanics;

import org.junit.Test;
import pcb.uwu.amount.base.KiloGrams;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.thermodynamics.Pascals;
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
		assertEquals("4.000000000000000 Kg",
				newtons.dividedBy(new Acceleration(3, new AccelerationUnit(METER, SECOND)), DECIMAL64).toString());
	}

	@Test
	public void dividedByMass() {
		assertEquals("3.00 s⁻²⋅m", newtons.dividedBy(new KiloGrams(4), DECIMAL64).toString());
	}

	@Test
	public void multipliedByLength() {
		assertEquals("60 J", newtons.multipliedBy(new Meters(5), DECIMAL64).toString());
	}

	@Test
	public void dividedByPressure() {
		assertEquals("4 m²", newtons.dividedBy(new Pascals(3), DECIMAL64).toString());
	}

	@Test
	public void dividedByArea() {
		assertEquals("3 Pa", newtons.dividedBy(new Area(4, SQUARE_METER), DECIMAL64).toString());
	}
}