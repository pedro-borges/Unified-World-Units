package pcb.uwu.amount.derived.thermodynamics;

import org.junit.Test;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.mechanics.Newtons;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER;

public class JoulesTest {
	private static final Joules joules = new Joules(200);

	@Test
	public void dividedByVolume() {
		assertEquals("40 Pa", joules.dividedBy(new Volume(5, CUBIC_METER), DECIMAL64).toString());
	}

	@Test
	public void dividedByPressure() {
		assertEquals("5 m³", joules.dividedBy(new Pascals(40), DECIMAL64).toString());
	}

	@Test
	public void dividedByPower() {
		assertEquals("5 s", joules.dividedBy(new Watts(40), DECIMAL64).toString());
	}

	@Test
	public void dividedByTime() {
		assertEquals("40 W", joules.dividedBy(new Seconds(5), DECIMAL64).toString());
	}

	@Test
	public void dividedByLength() {
		assertEquals("5 N", joules.dividedBy(new Meters(40), DECIMAL64).toString());
	}

	@Test
	public void dividedByForce() {
		assertEquals("40 m", joules.dividedBy(new Newtons(5), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricCharge() {
		assertEquals("5 V", joules.dividedBy(new Coulombs(40), DECIMAL64).toString());
	}

	@Test
	public void dividedByElectricPotential() {
		assertEquals("40 C", joules.dividedBy(new Volts(5), DECIMAL64).toString());
	}
}