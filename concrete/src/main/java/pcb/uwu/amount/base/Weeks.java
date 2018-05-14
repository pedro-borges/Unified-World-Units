package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.WeekUnit.WEEK;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
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

	@Override
	public Weeks plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Weeks(plusAmount(this, other, mathContext));
	}

	@Override
	public Weeks minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Weeks(minusAmount(this, other, mathContext));
	}

	@Override
	public Weeks multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Weeks dividedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
