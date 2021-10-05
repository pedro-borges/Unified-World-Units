package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.DayUnit.DAY;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Days extends Time {

	// region constructors

	public Days(Number value) {
		super(value, DAY);
	}

	public Days(Number value, Magnitude magnitude) {
		super(value, magnitude, DAY);
	}

	public Days(String value) {
		super(value, DAY);
	}

	public Days(String value, Magnitude magnitude) {
		super(value, magnitude, DAY);
	}

	public Days(BigDecimal value) {
		super(value, DAY);
	}

	public Days(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, DAY);
	}

	public Days(BigDecimalAmount amount) {
		super(amount, DAY);
	}

	public Days(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, DAY);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Days plus(@NotNull UnitAmount<TimeUnit> other) {
		return new Days(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Days minus(@NotNull UnitAmount<TimeUnit> other) {
		return new Days(minusAmount(this, other));
	}

	@Override
	public Days times(BigDecimal other, MathContext mathContext) {
		return new Days(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Days div(BigDecimal other, MathContext mathContext) {
		return new Days(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
