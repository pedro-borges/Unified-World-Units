package pcb.uwu.amount.composite.termodynamics;

import org.junit.Test;
import pcb.uwu.amount.composite.electromagnetism.Coulombs;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.amount.composite.fundamental.Volume;
import pcb.uwu.amount.composite.mechanics.Newtons;
import pcb.uwu.amount.quantity.Meters;
import pcb.uwu.amount.quantity.Seconds;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.fundamental.CubicMeterUnit.CUBIC_METER;

public class JoulesTest {
	private static final Joules joules = new Joules(200);

	@Test
	public void dividedByVolume() {
		assertEquals(new Pascals(40),
				joules.dividedBy(new Volume(5, CUBIC_METER), DECIMAL64));
	}

	@Test
	public void dividedByPressure() {
		assertEquals(new Volume(5, CUBIC_METER),
				joules.dividedBy(new Pascals(40), DECIMAL64));
	}

	@Test
	public void dividedByPower() {
		assertEquals(new Seconds(5),
				joules.dividedBy(new Watts(40), DECIMAL64));
	}

	@Test
	public void dividedByTime() {
		assertEquals(new Watts(40),
				joules.dividedBy(new Seconds(5), DECIMAL64));
	}

	@Test
	public void dividedByLength() {
		assertEquals(new Newtons(5),
				joules.dividedBy(new Meters(40), DECIMAL64));
	}

	@Test
	public void dividedByForce() {
		assertEquals(new Meters(40),
				joules.dividedBy(new Newtons(5), DECIMAL64));
	}

	@Test
	public void dividedByElectricCharge() {
		assertEquals(new Volts(5),
				joules.dividedBy(new Coulombs(40), DECIMAL64));
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals(new Coulombs(40),
				joules.dividedBy(new Volts(5), DECIMAL64));
	}
}