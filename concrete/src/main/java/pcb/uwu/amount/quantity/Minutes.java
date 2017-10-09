package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.MinuteUnit.MINUTE;

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

	@Override
	public Minutes plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Minutes(plusAmount(other, mathContext));
	}

	@Override
	public Minutes minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Minutes(minusAmount(other, mathContext));
	}

	@Override
	public Minutes multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes(multipliedByScalar(other, mathContext));
	}

	@Override
	public Minutes dividedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes(dividedByScalar(other, mathContext));
	}

	// endregion
}
