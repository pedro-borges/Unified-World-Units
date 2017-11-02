package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.HourUnit.HOUR;

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

	@Override
	public Hours plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Hours(plusAmount(other, mathContext));
	}

	@Override
	public Hours minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Hours(minusAmount(other, mathContext));
	}

	@Override
	public Hours multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Hours(multipliedByScalar(other, mathContext));
	}

	@Override
	public Hours dividedBy(BigDecimal other, MathContext mathContext) {
		return new Hours(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
