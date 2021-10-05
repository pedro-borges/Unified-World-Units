package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MinuteUnit.MINUTE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Minutes extends Time {

	// region constructors

	public Minutes(Number value) {
		super(value, MINUTE);
	}

	public Minutes(Number value, Magnitude magnitude) {
		super(value, magnitude, MINUTE);
	}

	public Minutes(String value) {
		super(value, MINUTE);
	}

	public Minutes(String value, Magnitude magnitude) {
		super(value, magnitude, MINUTE);
	}

	public Minutes(BigDecimal value) {
		super(value, MINUTE);
	}

	public Minutes(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, MINUTE);
	}

	public Minutes(BigDecimalAmount amount) {
		super(amount, MINUTE);
	}

	public Minutes(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, MINUTE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Minutes plus(@NotNull UnitAmount<TimeUnit> amount) {
		return new Minutes(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Minutes minus(@NotNull UnitAmount<TimeUnit> amount) {
		return new Minutes(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Minutes times(@NotNull Number number) {
		return new Minutes(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Minutes div(@NotNull Number number) {
		return new Minutes(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
