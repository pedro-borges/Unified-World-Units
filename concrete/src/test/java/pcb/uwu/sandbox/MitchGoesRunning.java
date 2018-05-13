package pcb.uwu.sandbox;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.mechanics.Speed;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.HourUnit.HOUR;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.MileUnit.MILE;
import static pcb.uwu.unit.base.MinuteUnit.MINUTE;

public class MitchGoesRunning {

	@Test
	public void testMitchGoesRunning() {
		Length mitchDistance = new Length(1000, METER);
		Time mitchTime = new Time(6, MINUTE);
		Speed mitchSpeed = mitchDistance.dividedBy(mitchTime, DECIMAL64);

		Length wifeDistance = new Length(1, MILE);
		Time wifeTime = new Time(11, MINUTE);
		Speed wifeSpeed = wifeDistance.dividedBy(wifeTime, DECIMAL64);

		SpeedUnit METERS_PER_HOUR = new SpeedUnit(METER, HOUR);

		assertEquals("10000.00000000000 h⁻¹⋅m", mitchSpeed.convertTo(METERS_PER_HOUR).toString());
		assertEquals("8778.240000000000 h⁻¹⋅m", wifeSpeed.convertTo(METERS_PER_HOUR).toString());
	}
}
