package pcb.uwu.amounts.composite.finance;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.finance.InterestRateUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class InterestRate extends AbstractUnitAmount<InterestRateUnit> {

	// region constructors

	public InterestRate(Number value, InterestRateUnit unit) {
		super(value, unit);
	}

	public InterestRate(Number value, Magnitude magnitude, InterestRateUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(String value, InterestRateUnit unit) {
		super(value, unit);
	}

	public InterestRate(String value, Magnitude magnitude, InterestRateUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(BigDecimal value, InterestRateUnit unit) {
		super(value, unit);
	}

	public InterestRate(BigDecimal value, Magnitude magnitude, InterestRateUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(BigDecimalAmount amount, InterestRateUnit unit) {
		super(amount, unit);
	}

	public InterestRate(BigDecimalAmount amount, Magnitude magnitude, InterestRateUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public InterestRate plus(UnitAmount<InterestRateUnit> other, MathContext mathContext) {
		return new InterestRate(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate minus(UnitAmount<InterestRateUnit> other, MathContext mathContext) {
		return new InterestRate(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate multipliedBy(BigDecimal other, MathContext mathContext) {
		return new InterestRate(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate dividedBy(BigDecimal other, MathContext mathContext) {
		return new InterestRate(dividedByAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate convertTo(InterestRateUnit unit) {
		return new InterestRate(getAmountIn(unit), unit);
	}

	// endregion
}
