package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.DayUnit.DAY;

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

	@Override
	public Days plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Days(plusAmount(other, mathContext));
	}

	@Override
	public Days minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Days(minusAmount(other, mathContext));
	}

	@Override
	public Days multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Days(multipliedByScalar(other, mathContext));
	}

	@Override
	public Days dividedBy(BigDecimal other, MathContext mathContext) {
		return new Days(dividedByScalar(other, mathContext));
	}

	// endregion
}
