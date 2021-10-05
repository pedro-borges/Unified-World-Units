package pcb.uwu.amount.derived.mechanics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit.METER_PER_SECOND;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

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

	@NotNull
	@Override
	public Meters times(@NotNull Time time) {
		return new Meters(UnitAmountUtils.times(this, getAmountIn(time, SECOND).getValue()));
	}

	@NotNull
	@Override
	public Seconds div(@NotNull Acceleration acceleration) {
		return new Seconds(dividedByScalar(this, getAmountIn(acceleration, new AccelerationUnit(METER_PER_SECOND, SECOND)).getValue()));
	}

	// endregion
}
