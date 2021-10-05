package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.WeekUnit.WEEK;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Weeks extends Time {

	// region constructors

	public Weeks(Number value) {
		super(value, WEEK);
	}

	public Weeks(Number value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(String value) {
		super(value, WEEK);
	}

	public Weeks(String value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(BigDecimal value) {
		super(value, WEEK);
	}

	public Weeks(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(BigDecimalAmount amount) {
		super(amount, WEEK);
	}

	public Weeks(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, WEEK);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Weeks plus(@NotNull UnitAmount<TimeUnit> other) {
		return new Weeks(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Weeks minus(@NotNull UnitAmount<TimeUnit> other) {
		return new Weeks(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Weeks times(@NotNull Number other) {
		return new Weeks(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Weeks div(@NotNull Number other) {
		return new Weeks(dividedByScalar(this, other));
	}

	// endregion
}
