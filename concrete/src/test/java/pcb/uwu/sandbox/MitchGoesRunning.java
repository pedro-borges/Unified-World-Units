package pcb.uwu.sandbox;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.mechanics.Speed;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.MileUnit.MILE;
import static pcb.uwu.unit.base.MinuteUnit.MINUTE;
import static pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit.METER_PER_SECOND;

public class MitchGoesRunning {

	@Test
	public void testMitchGoesRunning() {
		Length mitchDistance = new Length(1000, METER);
		Time mitchTime = new Time(6, MINUTE);
		Speed mitchSpeed = mitchDistance.dividedBy(mitchTime, DECIMAL64);

		Length wifeDistance = new Length(1, MILE);
		Time wifeTime = new Time(11, MINUTE);
		Speed wifeSpeed = wifeDistance.dividedBy(wifeTime, DECIMAL64);

		assertEquals("2.777777777777778 s⁻¹⋅m", mitchSpeed.in(METER_PER_SECOND).toString());
		assertEquals("2.438400000000000 s⁻¹⋅m", wifeSpeed.in(METER_PER_SECOND).toString());
	}
}
