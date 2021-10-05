package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.HourUnit.HOUR;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Hours extends Time {

	// region constructors

	public Hours(Number value) {
		super(value, HOUR);
	}

	public Hours(Number value, Magnitude magnitude) {
		super(value, magnitude, HOUR);
	}

	public Hours(String value) {
		super(value, HOUR);
	}

	public Hours(String value, Magnitude magnitude) {
		super(value, magnitude, HOUR);
	}

	public Hours(BigDecimal value) {
		super(value, HOUR);
	}

	public Hours(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, HOUR);
	}

	public Hours(BigDecimalAmount amount) {
		super(amount, HOUR);
	}

	public Hours(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, HOUR);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Hours plus(@NotNull UnitAmount<TimeUnit> other) {
		return new Hours(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Hours minus(@NotNull UnitAmount<TimeUnit> other) {
		return new Hours(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Hours times(@NotNull Number other) {
		return new Hours(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Hours div(@NotNull Number other) {
		return new Hours(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
