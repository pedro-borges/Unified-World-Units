package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit.METER_PER_SECOND;

public class MetersPerSecond extends Speed {

	// region constants

	public static final Speed SPEED_OF_LIGHT = new MetersPerSecond("299792458");

	// endregion

	// region constructors

	public MetersPerSecond(Number value) {
		super(value, METER_PER_SECOND);
	}

	public MetersPerSecond(Number value, Magnitude magnitude) {
		super(value, magnitude, METER_PER_SECOND);
	}

	public MetersPerSecond(String value) {
		super(value, METER_PER_SECOND);
	}

	public MetersPerSecond(String value, Magnitude magnitude) {
		super(value, magnitude, METER_PER_SECOND);
	}

	public MetersPerSecond(BigDecimal value) {
		super(value, METER_PER_SECOND);
	}

	public MetersPerSecond(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, METER_PER_SECOND);
	}

	public MetersPerSecond(BigDecimalAmount amount) {
		super(amount, METER_PER_SECOND);
	}

	public MetersPerSecond(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, METER_PER_SECOND);
	}

	// endregion

	// region composition

	@Override
	public Meters multipliedBy(Time time, MathContext mathContext) {
		return new Meters(super.multipliedByScalar(time.getAmountIn(SECOND).getValue(), mathContext));
	}

	// endregion
}
